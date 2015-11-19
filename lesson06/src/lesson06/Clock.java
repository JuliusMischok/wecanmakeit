package lesson06;


import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class Clock {
	private static final String HOST = "localhost";
    private static final int PORT = 4223;
    
    // TODO: Hier die mit dem Brickviewer ermittelte UID eintragen
    private static final String UID = "XYZ";

    private static IPConnection ipcon = new IPConnection(); 
    private static BrickletLCD20x4 lcd = new BrickletLCD20x4(UID, ipcon); 
    
    public static void main(String args[]) throws Exception {
        ipcon.connect(HOST, PORT);
        lcd.backlightOn();
        lcd.clearDisplay();
        
        // Uhrzeit
        int stunde = 9;
        int minute = 16;
        int sekunde = 32;
        String ausgabe = "";
        
        
        
        
        
        
        lcd.writeLine((short)0, (short)0, "Uhrzeit: " + ausgabe);
        
        /*
         * AUFGABE 1
         */
        int laenge = 10;
        int breite = 2;
        int hoehe = 2;
        
        int rauminhalt = inhalt(laenge, breite, hoehe);
        lcd.writeLine((short)1, (short)0, "Rauminhalt: " + rauminhalt);
        
        /*
         * AUFGABE 2
         */
        double schulaufgabe1 = 2; 
        double schulaufgabe2 = 1;
        double ex1 = 4;
        double ex2 = 1;
        double muendlich = 1;
        
        double schnitt = halbjahresSchnitt(schulaufgabe1, schulaufgabe2, ex1, ex2, muendlich);
        lcd.writeLine((short)2, (short)0, "Schnitt: " + schnitt);
        
        /*
         * AUFGABE 3
         */
        int note = schnittZuNote(schnitt);
        lcd.writeLine((short)3, (short)0, "Note: " + note);
    }
    
    /*
     * FUNKTION FUER AUFGABE 1
     */
    public static int inhalt(int laenge, int breite, int hoehe) {
    	int rauminhalt = 0;
    	
    	// TODO: Berechnung des Rauminhalts
    	
    	return rauminhalt;
    }
    
    /*
     * FUNKTION FUER AUFGABE 2
     */
    public static double halbjahresSchnitt(double sa1, double sa2, double ex1, double ex2, double m1) {
    	double schnitt = 0;
    	
    	// TODO: Berechnung des Notenschnitts
    	
    	return schnitt;
    }

    /*
     * FUNKTION FUER AUFGABE 3
     */
    public static int schnittZuNote(double schnitt) {
    	int note = 0;
    	
    	// TODO: Feststellen der Zeugnisnote
    	
    	return note;
    }    
    
    /*
     * FUNKTION FUER AUFGABE 4
     */
    public static String formatTime(int hour, int minute, int second, boolean is24h) {
    	String uhrzeit = "";
    	
    	// TODO: Formatieren der Uhrzeit
    	
    	return uhrzeit;
    }
}
