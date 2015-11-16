package lesson06;


import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class Clock {
	private static final String HOST = "localhost";
    private static final int PORT = 4223;
    
    // TODO: Hier die mit dem Brickviewer ermittelte UID eintragen
    private static final String UID = "ocV";

    public static void main(String args[]) throws Exception {
        IPConnection ipcon = new IPConnection(); 
        BrickletLCD20x4 lcd = new BrickletLCD20x4(UID, ipcon); 
        ipcon.connect(HOST, PORT);
        lcd.backlightOn();
        lcd.clearDisplay();
        
        
        
        
        // FIXME: UID raus!
         
        
        

        // Uhrzeit
        int stunde = 9;
        int minute = 16;
        int sekunde = 32;
        String ausgabe = "";
        
        // Erster Versuch
        ausgabe = stunde + ":" + minute + ":" + sekunde;
        
        // REFACTOR: Erster Versuch
        ausgabe = "" + stunde;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + minute;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + sekunde;
        System.out.println("1: " + ausgabe);
        
        // REFACTOR: Zweiter Versuch
        ausgabe = "";
        if (stunde < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = ausgabe + stunde;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + minute;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + sekunde;
        System.out.println("2: " + ausgabe);
        
        // Änderung der Datengrundlage
        sekunde = 8;
        
        // REFACTOR: Dritter Versuch
        ausgabe = "";
        if (stunde < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = ausgabe + stunde;
        ausgabe = ausgabe + ":";
        ausgabe = ausgabe + minute;
        ausgabe = ausgabe + ":";
        if (sekunde < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = ausgabe + sekunde;
        System.out.println("3: " + ausgabe);
        
        // Änderung der Datengrundlage...
        minute = 3;
        
        // REFACTOR: Vierter Versuch
        ausgabe = "";
        if (stunde < 10) {
        	ausgabe = ausgabe + "0";
        }
        ausgabe = ausgabe + stunde;
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
        System.out.println("4: " + ausgabe);
        
        // REFACTOR: Fünfter Versuch
        ausgabe = padLeft(stunde) + ":";
        ausgabe = ausgabe + padLeft(minute) + ":";
        ausgabe = ausgabe + padLeft(sekunde);
        System.out.println("5: " + ausgabe);
        
        // REFACTOR: Sechster Versuch
        ausgabe = formatTime(stunde, minute, sekunde);
        System.out.println("6: " + ausgabe);
        
        
        // FIXME: Aufgabe: Anpassung von formatTime, so dass Uhrzeit im 12h Format ausgegeben wird
        
        
    }
    
    public static String padLeft(int zahl) {
    	String result = "";
    	
    	if (zahl < 10) {
    		result = result + "0";
    	}
    	
    	result = result + zahl;
    	
    	return result;
    }
    
    public static String formatTime(int hour, int minute, int second) {
    	return padLeft(hour) + ":" + padLeft(minute) + ":" + padLeft(second);
    }
}
