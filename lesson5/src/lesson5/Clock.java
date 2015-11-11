package lesson5;


import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class Clock {
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
        
        // Uhrzeit
        int stunde = 9;
        int minute = 16;
        int sekunde = 32;
        String ausgabe = "";
        
        // Erster Versuch
        ausgabe = stunde + ":" + minute + ":" + sekunde;
        
        // REFACTOR
        ausgabe = "" + stunde;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + minute;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + sekunde;
        
        // REFACTOR: Zweiter Versuch
        if (stunde < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = "" + stunde;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + minute;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + sekunde;
        
        // Änderung der Datengrundlage
        sekunde = 8;
        
        // REFACTOR: Dritter Versuch
        if (stunde < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = "" + stunde;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + minute;
        ausgabe = ausgabe + ":";
        if (sekunde < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = ausgabe + sekunde;
        
        // Änderung der Datengrundlage...
        minute = 3;
        
        // REFACTOR: Vierter Versuch
        if (stunde < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = "" + stunde;
        ausgabe = ausgabe + ":";
        if (minute < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = ausgabe + minute;
        ausgabe = ausgabe + ":";
        if (sekunde < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = ausgabe + sekunde;
        
        // REFACTOR: Fünfter Versuch
        ausgabe = padLeft(stunde) + ":";
        ausgabe = ausgabe + padLeft(minute) + ":";
        ausgabe = ausgabe + padLeft(sekunde);
    }
    
    public static String padLeft(int zahl) {
    	String result = "";
    	
    	if (zahl < 10) {
    		result = result + "0";
    	}
    	
    	result = result + zahl;
    	
    	return result;
    }
}
