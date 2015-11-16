package lesson5;


import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class HelloFunctions {
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
        double einzelpreis = 4.99;
        int anzahl = 120;
        
        /*
         * Aufgabe 2
         */
        double preisMitRabatt = berechnePreis(einzelpreis, anzahl);
                
        /*
         * Aufgabe 3
         */
        double gradCelsius = 100;
        
        double gradFahrenheit = celsiusInFahrenheit(gradCelsius);
        
        /*
         * Aufgabe 4
         */
        
    }
    
    /*
     * Funktion fuer Aufgabe 2
     */
    public static double berechnePreis(double einzelpreis, int anzahl) {
    	return 0;
    }
    
    /*
     * Funktion fuer Aufgabe 3
     */
    public static double celsiusInFahrenheit(double celsius) {
    	return 0;
    }    
}
