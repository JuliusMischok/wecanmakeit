package de.wecanmakeit.lesson01;

import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class HelloWorld {
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
        
        
        lcd.writeLine((short)0, (short)0, "Hello World");
        

    }
}
