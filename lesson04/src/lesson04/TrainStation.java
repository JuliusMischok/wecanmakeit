package lesson04;

import com.tinkerforge.BrickletLCD20x4;
import com.tinkerforge.IPConnection;

public class TrainStation {
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
        
        // Daten der Fahrt
        String bahnhofVon = "Aug Hbf";
        int abfahrtStunde = 13;
        int abfahrtMinute = 54;
        int abfahrtGleis = 1;
        String bahnhofNach = "Ber Hbf";
        int ankunftStunde = 20;
        int ankunftMinute = 6;
        int ankunftGleis = 7;
        boolean zugEinsatzbereit = true;
        
        // Strings für die Anzeige
        String zeile1 = "";
        String zeile2 = "";
        String zeile3 = "";
        String zeile4 = "";
        
        /*
         * ERSTE ZEILE: Strecke
         */
        zeile1 = "";
        
        /*
         * ZWEITE ZEILE: Abfahrt
         */
        zeile2 = "";
        
        /*
         * DRITTE ZEILE: Ankunft 
         */
        zeile3 = "";
        
        /*
         * VIERTE ZEILE: Status
         */
        zeile4 = "";
        
        lcd.writeLine((short)0, (short)0, zeile1);
        lcd.writeLine((short)1, (short)0, zeile2);
        lcd.writeLine((short)2, (short)0, zeile3);
        lcd.writeLine((short)3, (short)0, zeile4);
        
        /*
         * AUFGABE 1
         */
//        int jahreszahl = 2015;
//        int jahrMod4 = ???;
//        int jahrMod100 = ???;
//        int jahrMod400 = ???;
        
        /*
         * AUFGABE 2 
         */
//        int alter = 15;
//        if (alter >= 13 && alter < 20) {
//        	lcd.writeLine((short)0, (short)0, "Du bist Teenager!");
//        }
//        boolean dreizehnOderAelter = alter >= 13;
//        boolean unterZwanzig = alter < 20;
        
    }
}
