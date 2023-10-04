package sew9.worttrainer.dwinter187;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.swing.*;

/**
 * baut die Klassen WortEintrag, WortTrainer und WortListe ein 
 * @author Daniel Winter
 * 
 * @version 04.10.23
 */
public class App {
    /**
     * baut die Klassen WortEintrag, WortTrainer und WortListe ein 
     */
    public static void main(String[] args) {

        //Worteintrag
        WortEintrag worteintrag1 = new WortEintrag("Fotograph", "https://images.unsplash.com/photo-1575936123452-b67c3203c357?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8fDA%3D&w=1000&q=80");
        WortEintrag worteintrag2 = new WortEintrag("Auge", "https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg");
        WortEintrag worteintrag3 = new WortEintrag("Baum", "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_640.jpg");

        //Wortliste
        WortListe wortliste1 = new WortListe();
        wortliste1.addWort(worteintrag1);
        wortliste1.addWort(worteintrag2);
        wortliste1.addWort(worteintrag3);

        //Worttrainer
        WortTrainer trainer = new WortTrainer(wortliste1);
        SpeichernUndLaden sul = new SpeichernUndLaden(trainer);
        try {
            sul.laden();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler bei laden");
        }

        Random r = new Random();
        boolean wortRichtig = true;
        boolean spielBeendet = false;
        ImageIcon image;
        String antwort = "";
        String VorherigerVersuch = "";

        JOptionPane.showMessageDialog(null, "Herzlich Willkommen zu meinem Worttrainer");
        while(!spielBeendet) {
            WortEintrag neuesWort = trainer.getWortListe().getListe()[r.nextInt(trainer.getWortListe().getListe().length)];
            
            do {
                try {
                    image = new ImageIcon(new URL(neuesWort.getUrl()));
                    JOptionPane.showMessageDialog(null, "Bisher Richtige: "+trainer.getRichtige()+"\nBisher Falsche: "+trainer.getFalsche()+"\nDer Versuch davor: " +VorherigerVersuch+ "\nMerk dir dieses Bild genau", "Display Image", JOptionPane.INFORMATION_MESSAGE, image);
                    antwort = JOptionPane.showInputDialog(null, "Was war das Bild?");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Fehler");
                }
                
                if(antwort.equals("")){
                    try {
                        sul.speichern();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Fehler bei speichern");
                    }
                    spielBeendet = true;
                    break;
                }
                if(antwort.equals(neuesWort.getWort())) {
                    JOptionPane.showMessageDialog(null, "Richtig :)");
                    trainer.addRichtige(1);
                    wortRichtig = true;
                    VorherigerVersuch = "Richtig";
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch :(");
                    trainer.addFalsche(1);
                    wortRichtig = false;
                    VorherigerVersuch = "Falsch";
                }
            } while (!wortRichtig);
            
        }
        JOptionPane.showMessageDialog(null, "Richtig: "+trainer.getRichtige()+" Falsch: "+trainer.getFalsche());
    
    }
}
