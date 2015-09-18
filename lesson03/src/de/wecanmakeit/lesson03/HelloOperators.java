package de.wecanmakeit.lesson03;

import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class HelloOperators {
	private static final String HOST = "localhost";
    private static final int PORT = 4223;
    
    // TODO: Hier die mit dem Brickviewer ermittelte UID eintragen
    private static final String UID = "XYZ";

    public static void main(String args[]) throws Exception {
        IPConnection ipcon = new IPConnection(); 
        BrickletLCD20x4 lcd = new BrickletLCD20x4(UID, ipcon); 
        ipcon.connect(HOST, PORT);
        lcd.backlightOn();
        lcd.clearDisplay();
        
        
        int geburtsjahr = 2001;
        int aktuellesJahr = 2015;
        
        boolean istVolljaehrig = false;
        
        
    }
}
