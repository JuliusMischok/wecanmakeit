package de.wecanmakeit.lesson02;

import com.tinkerforge.BrickletHumidity;
import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class HelloConditions {
	private static final String HOST = "localhost";
    private static final int PORT = 4223;
    
    // TODO: Hier die mit dem Brickviewer ermittelte UID eintragen
    private static final String UID = "ocV";
    private static final String UID_HUMIDITY = "nxe";
    
    public static void main(String args[]) throws Exception {
        IPConnection ipcon = new IPConnection(); 
        BrickletLCD20x4 lcd = new BrickletLCD20x4(UID, ipcon); 
        BrickletHumidity hum = new BrickletHumidity(UID_HUMIDITY, ipcon);
        ipcon.connect(HOST, PORT);
        lcd.backlightOn();
        lcd.clearDisplay();
        
        
        int alter = 14;
        String vorname = "Max";
        String nachname = "Mustermann";
        String anrede = "";
        String name = "";
        
        int humidity = (int)(hum.getHumidity() / 10.0);
        lcd.writeLine((short)0, (short)0, humidity + "%RH");
        
        int geburtsTag = 18;
        int geburtsMonat = 2;
        int geburtsJahr = 1986;
        int heuteTag = 20;
        int heuteMonat = 10;
        int heuteJahr = 2015;
        
        int alterHeute = heuteJahr - geburtsJahr; // Alter zum Jahresende
        if (geburtsMonat > heuteMonat) {
        	// Geburtstag steht noch an, ein Jahr abziehen
        	alterHeute = alterHeute - 1;
        } else {
        	if (geburtsMonat == heuteMonat) {
        		// Prüfen, in der Zukunft liegt
        		if (geburtsTag > heuteTag) {
        			// Steht noch an, ein Jahr abziehen
        			alterHeute = alterHeute - 1;
        		}
        	}
        }
        
        lcd.writeLine((short)2, (short)0, "Alter: " + alterHeute);
    }
}
