package sew9.worttrainer.dwinter187;

import java.util.Random;

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

        //Worteintrag
        WortEintrag worteintrag1 = new WortEintrag("eins", "https://www.eins.com");
        WortEintrag worteintrag2 = new WortEintrag("zwei", "http://www.zwei.com");
        WortEintrag worteintrag3 = new WortEintrag("drei", "http://www.drei.com");

        //Wortliste
        WortListe wortliste1 = new WortListe();
        wortliste1.addWort(worteintrag1);
        wortliste1.addWort(worteintrag2);
        wortliste1.addWort(worteintrag3);

        //Worttrainer
        WortTrainer trainer = new WortTrainer(wortliste1);

        Random r = new Random();
        boolean wortRichtig = true;
        boolean spielBeendet = false;

        JOptionPane.showMessageDialog(null, "Herzlich Willkommen zu meinem Worttrainer");
        while(!spielBeendet) {
            WortEintrag neuesWort = trainer.getWortListe().getListe()[r.nextInt(trainer.getWortListe().getListe().length)];
            
            do {
                String antwort = JOptionPane.showInputDialog(null, "Welches Bild ist das? "+neuesWort.getUrl());
                if(antwort.equals("")){
                    spielBeendet = true;
                    break;
                }
                if(antwort.equals(neuesWort.getWort())) {
                    JOptionPane.showMessageDialog(null, "Richtig :)");
                    trainer.addRichtige(1);
                    wortRichtig = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch :(");
                    trainer.addFalsche(1);
                    wortRichtig = false;
                }
            } while (!wortRichtig);
            
        }
        JOptionPane.showMessageDialog(null, "Richtig: "+trainer.getRichtige()+" Falsch: "+trainer.getFalsche());
    
    }
}
