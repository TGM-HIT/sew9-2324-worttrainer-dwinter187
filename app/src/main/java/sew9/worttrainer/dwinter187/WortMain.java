package sew9.worttrainer.dwinter187;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * baut die Klassen WortEintrag, WortTrainer und WortListe ein 
 * @author Daniel Winter
 * 
 * @version 14.11.21
 */
public class WortMain {
    /**
     * baut die Klassen WortEintrag, WortTrainer und WortListe ein 
     */
    public static void main(String[] args) {

        // Hier werden die Methoden von WortEintrag überprüft

        WortEintrag worteintrag1= new WortEintrag("AutO", "https://autO.com");
        WortEintrag worteintrag2= new WortEintrag("MauS", "http://mauS.com");



        WortListe wortliste = new WortListe();                                 //erstellt eine neue WortListe
        wortliste.addWort(worteintrag1);
        wortliste.addWort(worteintrag2);
        
        WortTrainer trainer = new WortTrainer(wortliste);



        //ruft die Methode speichern auf und fängt sie auf falls ein Fehler auftritt
        try {
			SpeichernUndLaden.speichern(trainer);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Beim Speichern ist ein Fehler aufgetreten!!! Details: "+e.getMessage());
		}


        //ruft die Methode laden auf und fängt sie auf falls ein Fehler auftritt
        WortTrainer trainer2 = null;
		try {
			trainer2 = SpeichernUndLaden.laden();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Beim Laden ist ein Fehler aufgetreten!!! Details: "+e.getMessage());
		}
        String n="";
        for (int i = 0; i < trainer2.getWortListe().getListe().length; i++) {
            n+=trainer2.getWortListe().getListe()[i]+"\n";
        }
        System.out.println(n);
    }
}