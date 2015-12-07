package lesson08;

import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class MoreLoops {
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
        
        /*
         * Aufruf von Aufgabe 1
         */
        int zahl = 5;
        int fakultaet = fakultaet(zahl);
        lcd.writeLine((short)0, (short)0, zahl + "! = " + fakultaet);
        
        /*
         * Aufruf von Aufgabe 2
         */
        int von = 5;
        int bis = 15;
        int anzahl = anzahlDurch3Teilbar(von, bis);
        lcd.writeLine((short)1, (short)0, "Anzahl: " + anzahl);
        
        /*
         * Aufruf von Aufgabe 3*
         */
        int jahr = 1999;
        int schaltjahr = erstesSchaltjahrNach(jahr);
        lcd.writeLine((short)2, (short)0, "SJ: " + schaltjahr);

        /*
         * Aufruf von Aufgabe 4*
         */
        double rueckgeld = 5.20;
        int anzahl2Euro = anzahlMuenzen(rueckgeld, 2.0);
        lcd.writeLine((short)3, (short)0, "Gib " + anzahl2Euro + "x 2 Euro aus");
    }
    
    /**
     * Aufgabe 1
     */
    public static int fakultaet(int zahl) {
    	int ergebnis = 1;
    	
    	// TODO: Lösung Aufgabe 1
    	
    	return ergebnis;
    }
    
    /**
     * Aufgabe 2
     */
    public static int anzahlDurch3Teilbar(int von, int bis) {
    	int anzahl = 0;
    	
    	// TODO: Lösung Aufgabe 2
    	
    	return anzahl;
    }
    
    /**
     * Aufgabe 3*
     */
    public static int erstesSchaltjahrNach(int jahr) {
    	int erstesSchaltjahr = 0;
    	
    	// TODO: Lösung Aufgabe 3
    	
    	return erstesSchaltjahr;
    }

    /**
     * DIESE FUNKTION NUR VERWENDEN, NICHT BEARBEITEN
     */
    public static boolean istSchaltjahr(int jahr) {
    	return ((jahr % 4 == 0 && jahr % 100 != 0) || (jahr % 4 == 0 && jahr % 400 == 0));
    }
    
    /**
     * Aufgabe 4
     */
    public static int anzahlMuenzen(double rueckgeld, double muenze) {
    	int anzahl = 0;
    	
    	// TODO: Lösung Aufgabe 4
    	
    	return anzahl;
    }
    
}
