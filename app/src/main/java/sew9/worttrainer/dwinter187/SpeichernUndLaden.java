package sew9.worttrainer.dwinter187;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Die Klasse SpeichernUndLaden
 * @author jschulz
 * @version 04-12-2021
 */
public class SpeichernUndLaden{
    /**
     * speichert die Worteintraege und die Statistik dazu in der angegebenen Datei
     * @param filename Das File in das alles gespeichert werden soll
     * @param worttrainer Die Worteintraege und die Statistik
     * @throws IOException
     */
    public static void speichern(String filename, WortTrainer worttrainer) throws IOException {
		File file = new File(filename);
		BufferedWriter writer = null;
		WortEintrag[] wortliste = worttrainer.getWortListe().getListe();
		int richtige = worttrainer.getRichtige();
		int falsche = worttrainer.getFalsche();
		writer = new BufferedWriter(new FileWriter(file));
		writer.write(richtige + System.lineSeparator() + falsche + System.lineSeparator());
		for (int i = 0; i < wortliste.length; ++i) {
			writer.write(wortliste[i].getWort() + ";" + wortliste[i].getUrl() + System.lineSeparator());
		}
		if (writer != null) {
			writer.close();
		}
	} 
    /**
     * speichert die Worteintraege und die Statistik dazu in der angegebenen Datei im Projekt Ordner
     * @param trainer Die Worteintraege und die Statistik
     */
    public static void speichern(WortTrainer trainer) throws IOException {
        speichern("WortTrainer.txt", trainer);
    }
    /**
	 * lädt die Worteintraege und die Statistik in der angegebenen Datei
	 * @param filename Der Pfad zur Datei
	 * @return Den Worttrainer mit den Daten aus der Datei
	 */
    public static WortTrainer laden(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
		String text;
		int richtige = Integer.parseInt(reader.readLine());
		int falsche = Integer.parseInt(reader.readLine());		
		WortTrainer worttrainer = new WortTrainer();
		worttrainer.addRichtige(richtige);
		worttrainer.addFalsche(falsche);		
		while ((text = reader.readLine()) != null) {
			worttrainer.getWortListe().addWort(new WortEintrag(text.substring(0, text.indexOf(';')), text.substring(text.indexOf(';')+1,text.length())));
		}
		reader.close();
		return worttrainer;
    }
    /**
	 * lädt die Worteintraege und die Statistik in der angegebenen Datei im Projekt Ordner
	 * @param filename Der Pfad zur Datei
	 * @return Den Worttrainer mit den Daten aus der Datei
	 */
    public static WortTrainer laden() throws IOException {
        return laden("Worttrainer.txt");
    }
}