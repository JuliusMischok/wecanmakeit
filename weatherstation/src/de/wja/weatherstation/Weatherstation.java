package de.wja.weatherstation;

import com.tinkerforge.BrickletAmbientLight;
import com.tinkerforge.BrickletAmbientLight.IlluminanceListener;
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
    private final BrickletAmbientLight ambient; // FIXME: V1 oder V2???
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
    	this.ambient = new BrickletAmbientLight(UID_AMBIENTLIGHT, ipcon);
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

    /**
     * Wird aufgerufen, wenn ein Button am LCD-Display gedrückt wurde
     * @param button Nummer des Buttons 
     */
	@Override
	public void buttonPressed(short button) {
		// Hier kannst du eine Aktion programmieren, die beim Drücken eines
		// Buttons ausgeführt werden soll.

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
		// Wenn du den Wert von humidity durch 10.0 teilst, erhältst du die 
		// relative Luftfeuchtigkeit in % und kannst mit ihr weiterarbeiten.	

	}

	/**
	 * Wird aufgerufen, wenn sich der Luftdruck ändert
	 * @param airPressure Luftdruck, der Wert muss durch 10.0 geteilt werden um den Luftdruck in Hektopascal zu erhalten
	 */
	@Override
	public void airPressure(int airPressure) {
		// Wenn du den Wert von airPressure durch 10.0 teilst, erhältst du 
		// den Luftdruck in Hektopascal und kannst mit ihm weiterarbeiten.

	}

	/**
	 * Wird aufgerufen, wenn sich die Helligkeit ändert
	 * @param illuminance Helligkeit, der Wert muss durch 100.0 geteilt werden um die Helligkeit in Lux zu erhalten
	 */
	@Override
	public void illuminance(int illuminance) {
		// Wenn du den Wert von illuminance durch 100.0 teilst, erhältst du die
		// Helligkeit in Lux und kannst mit ihr weiterarbeiten.

	}
}
