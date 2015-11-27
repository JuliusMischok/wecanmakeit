package lesson07;

import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class HelloLoops {
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
         * Aufgabe 1
         */
        double schnitt = notenSchnitt(2, 1, 3, 1);
        lcd.writeLine((short)0, (short)0, "Schnitt: " + schnitt);
        
        /*
         * Aufgabe 2
         */
        int summeVon1BisN = summe(15);
        lcd.writeLine((short)1, (short)0, "Summe: " + summeVon1BisN);
        
        /*
         * Aufgabe 3
         */
        int von = 1800;
        int bis = 2000;
        int anzahlSJ = schaltjahre(von, bis);
        lcd.writeLine((short)2, (short)0, "Schaltjahre:" + anzahlSJ);

        /*
         * Aufgabe 4
         */
        double preis = 18.78;
        int vorkomma = vorkomma(preis);
        double nachkomma = nachkomma(preis);
        lcd.writeLine((short)3, (short)0, "VK: " + vorkomma + " NK: " + nachkomma);
    }
    
    /**
     * AUFGABE 1
     */
    public static double notenSchnitt(int sa1, int sa2, int sa3, int sa4) {
    	double schnitt = 0;
    	
    	// TODO: Notenschnitt berechnen, Typumwandlung beachten!
    	
    	return schnitt;
    }
    
    /**
     * AUFGABE 2
     */
    public static int summe(int n) {
    	int summe = 0;
    	
    	// TODO: Summe berechnen  	
    	
    	return summe;
    }
    
    /**
     * Aufgabe 3
     */
    public static int schaltjahre(int von, int bis) {
    	int anzahl = 0;
    	
    	// TODO: Anzahl der Schaltjahre berechnen
    	
    	return anzahl;
    }
    
    public static boolean istSchaltjahr(int jahr) {
    	return ((jahr % 4 == 0 && jahr % 100 != 0) || (jahr % 4 == 0 && jahr % 400 == 0));
    }
    
    /**
     * Aufgabe 4*
     */
    public static int vorkomma(double zahl) {
    	int vorkomma = 0;
    	
    	// TODO: Vorkommateil bestimmen
    	
    	return vorkomma;
    }
    
    public static double nachkomma(double zahl) {
    	double nachkomma = 0;
    	
    	// TODO: Nachkommateil bestimmen
    	
    	return nachkomma;
    }
    
    /**
     * Aufgabe 5*
     */
    public static int summeGauss(int n) {
    	int summe = 0;
    	
    	// TODO: Summe mit Gaußscher Formel berechnen
    	
    	return summe;
    }
}
