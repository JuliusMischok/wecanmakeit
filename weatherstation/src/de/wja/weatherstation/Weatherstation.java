package de.wja.weatherstation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.tinkerforge.BrickletAmbientLightV2;
import com.tinkerforge.BrickletAmbientLightV2.IlluminanceListener;
import com.tinkerforge.BrickletBarometer;
import com.tinkerforge.BrickletBarometer.AirPressureListener;
import com.tinkerforge.BrickletHumidity;
import com.tinkerforge.BrickletHumidity.HumidityListener;
import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.BrickletLCD20x4.ButtonPressedListener;
import com.tinkerforge.BrickletLCD20x4.ButtonReleasedListener;
import com.tinkerforge.IPConnection;

/**
 * Wetterstationsklasse des Projekts "we can make IT"
 * 
 * @author Julius Mischok
 *
 */
public class Weatherstation implements ButtonPressedListener, ButtonReleasedListener, IlluminanceListener, AirPressureListener, HumidityListener {
	private static final String HOST = "localhost";
    private static final int PORT = 4223;
    
    // Hier die mit dem Brickviewer ermittelte UIDs eintragen
    private static final String UID_LCD = "XYZ";
    private static final String UID_AMBIENTLIGHT = "XYZ";
    private static final String UID_BAROMETER = "XYZ";
    private static final String UID_HUMIDITY = "XYZ";

    private final IPConnection ipcon; 
    private final BrickletLCD20x4 lcd;
    private final BrickletAmbientLightV2 ambient; 
    private final BrickletBarometer barometer;
    private final BrickletHumidity humidity;
    
    /**
     * *** BITTE NICHT ANFASSEN! ***
     * Konstruktor
     * Hier wird die Verbindung zur Wetterstation hergestellt
     * @throws Exception Wird geworfen, wenn es bei der Verbindung zur Wetterstation zu einem Fehler kommt
     */
    private Weatherstation() throws Exception {
    	this.ipcon = new IPConnection();
    	this.lcd = new BrickletLCD20x4(UID_LCD, ipcon);
    	this.ambient = new BrickletAmbientLightV2(UID_AMBIENTLIGHT, ipcon);
    	this.barometer = new BrickletBarometer(UID_BAROMETER, ipcon);
    	this.humidity = new BrickletHumidity(UID_HUMIDITY, ipcon);
    	
    	this.lcd.addButtonPressedListener(this);
    	this.lcd.addButtonReleasedListener(this);
    	this.ambient.addIlluminanceListener(this);
    	this.barometer.addAirPressureListener(this);
    	this.humidity.addHumidityListener(this);
    	
    	this.ipcon.connect(HOST, PORT);
    }
    
    /**
     * *** BITTE NICHT ANFASSEN! ***
     * Startmethode der Wetterstation
     * @param args Kommandozeilenparameter
     * @throws Exception Wird bei Fehlern beim Verbindungsaufbau zur Wetterstation geworfen
     */
    public static void main(String[] args) throws Exception {
    	Weatherstation weatherstation = new Weatherstation();
 	
    	// Initialisieren
    	weatherstation.init();
   
    	// Starthinweis ausgeben
    	System.out.println("Zum Beenden hier klicken und die 'Enter' Taste druecken..."); 
        weatherstation.lcd.writeLine((short)0, (short)0, "Station startet...");
    	weatherstation.lcd.writeLine((short)1, (short)0, "Zum Beenden in der");
    	weatherstation.lcd.writeLine((short)2, (short)0, "'Console' die Taste");
    	weatherstation.lcd.writeLine((short)3, (short)0, "'Enter' druecken.");
    	Thread.sleep(7000);
    	weatherstation.lcd.clearDisplay();
    	
    	// So lange laufen lassen, bis eine Taste gedrückt wird
        System.in.read();
        weatherstation.disconnect();
    }
    
    /**
     * *** BITTE NICHT ANFASSEN! ***
     * Beendet die Verbindung zur Wetterstation
     * @throws Exception Wird bei Fehlern beim Verbindungsabbau geworfen
     */
    private void disconnect() throws Exception {
    	this.ipcon.disconnect();
    }

    /**
     * *** BITTE NICHT ANFASSEN ***
     * @param part Teil des Datums, das ausgegeben werden soll. Mögliche Werte:
     * 			"yyyy" 	liefert das Jahr
     * 			"MM"	liefert den Monat
     * 			"dd"	liefert den Tag im Monat
     * 			"HH"	liefert die Stunden
     * 			"mm"	liefert die Minuten
     * 			"ss"	liefert die Sekunden
     * 			"F"		liefert den Index des Wochentages
     * @return Datums- oder Uhrzeitteil
     */
    public int getDatePart(String part) {
    	return Integer.valueOf(new SimpleDateFormat(part).format(Calendar.getInstance().getTime()));
    }
        
    /**
     * Diese Methode wird beim Starten der Wetterstation aufgerufen. Wenn du
     * eine Aktion vor allen anderen Schritten ausführen möchtest, kannst du 
     * das hier tun.
     */
    public void init() throws Exception {
    	// Abfrageintervall der Sensoren auf eine Sekunde setzen
    	this.humidity.setHumidityCallbackPeriod(1000);
    	this.barometer.setAirPressureCallbackPeriod(1000);
    	this.ambient.setIlluminanceCallbackPeriod(1000);
    	
        // Hintergrundlicht einschalten und Display leeren
    	this.lcd.backlightOn();
        this.lcd.clearDisplay();
    
        // Weitere Schritt für die Initialisierung...
        
    }
    
    public void writeLine(int line, String text) throws Exception {
    	// Zeile mit Leerzeichen füllen
    	lcd.writeLine((short)line, (short)0, "                    ");
    		
    	// Text ausgeben
    	lcd.writeLine((short)line, (short)0, text);
    }

    /**
     * Wird aufgerufen, wenn ein Button am LCD-Display gedrückt wurde
     * @param button Nummer des Buttons 
     */
	@Override
	public void buttonPressed(short button) {
		try {
			
			// Je nach Button unterscheiden
			if (button == 0) {
				// Temperatur holen und umrechnen
				double temp = (double)barometer.getChipTemperature() / 100.0;
				
				// Temperatur ausgeben
				writeLine(0, "Temp.: " + temp + " Grad C");
			}
			if (button == 1) {
				// Datum ausgeben
				writeLine(0, getDatePart("dd") + "." + getDatePart("MM") + "." + getDatePart("yyyy"));
			}
			if (button == 2) {
				// Uhrzeit ausgeben
				writeLine(0, getDatePart("HH") + "." + getDatePart("mm") + "." + getDatePart("ss"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wird aufgerufen, wenn ein Button am LCD-Display losgelassen wurde
	 * @param button Nummer des Buttons
	 */
	@Override
	public void buttonReleased(short button) {
		// Hier kannst du eine Aktion programmieren, die beim Loslassen eines
		// Buttons ausgeführt werden soll.

	}

	/**
	 * Wird aufgerufen, wenn sich die Luftfeuchtigkeit ändert
	 * @param humidity Luftfeuchtigkeit, der Wert muss durch 10.0 geteilt werden um den relativen Luftdruck in % zu erhalten
	 */
	@Override
	public void humidity(int humidity) {
		try {
			
			// Erst mal in die korrekte Kommazahl umrechnen
			double humDbl = ((double)humidity) / 10.0;
			
			// Auf dem Display ausgeben
			writeLine(1, "RL: " + humDbl + "%");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wird aufgerufen, wenn sich der Luftdruck ändert
	 * @param airPressure Luftdruck, der Wert muss durch 1000.0 geteilt werden um den Luftdruck in Hektopascal zu erhalten
	 */
	@Override
	public void airPressure(int airPressure) {
		try {
			
			// Erst mal in die korrekte Kommazahl umrechnen
			double prsDbl = ((double)airPressure) / 1000.0;
			
			// Auf dem Display ausgeben
			writeLine(3, "Dru: " + prsDbl + " hPa");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wird aufgerufen, wenn sich die Helligkeit ändert
	 * @param illuminance Helligkeit, der Wert muss durch 100.0 geteilt werden um die Helligkeit in Lux zu erhalten
	 */
	@Override
	public void illuminance(long illuminance) {
		try {
			
			// Erst mal in die korrekte Kommazahl umrechnen
			double illDbl = ((double)illuminance) / 100.0;
			
			// Auf dem Display ausgeben
			writeLine(2, "Hel: " + illDbl + " lx");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
