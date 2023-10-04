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
	public WortTrainer wortTrainer;
	public SpeichernUndLaden(WortTrainer wortTrainer){
		this.wortTrainer = wortTrainer;
	}

    /**
     * speichert die Worteintraege und die Statistik dazu in der angegebenen Datei
     * @param filename Das File in das alles gespeichert werden soll
     * @param worttrainer Die Worteintraege und die Statistik
     * @throws IOException
     */
    public void speichern(String filename) throws IOException {
		File file = new File(filename);
		BufferedWriter writer = null;
		int richtige = this.wortTrainer.getRichtige();
		int falsche = this.wortTrainer.getFalsche();
		writer = new BufferedWriter(new FileWriter(file));
		writer.write(richtige + System.lineSeparator() + falsche + System.lineSeparator());
		writer.close();
	} 
    /**
     * speichert die Worteintraege und die Statistik dazu in der angegebenen Datei im Projekt Ordner
     * @param trainer Die Worteintraege und die Statistik
     */
    public void speichern() throws IOException {
        speichern("WortTrainer.txt");
    }
    /**
	 * lädt die Worteintraege und die Statistik in der angegebenen Datei
	 * @param filename Der Pfad zur Datei
	 * @return Den Worttrainer mit den Daten aus der Datei
	 */
    public void laden(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
		int richtige = Integer.parseInt(reader.readLine());
		int falsche = Integer.parseInt(reader.readLine());
		wortTrainer.addRichtige(richtige);
		wortTrainer.addFalsche(falsche);
		reader.close();
    }
    /**
	 * lädt die Worteintraege und die Statistik in der angegebenen Datei im Projekt Ordner
	 * @param filename Der Pfad zur Datei
	 * @return Den Worttrainer mit den Daten aus der Datei
	 */
    public void laden() throws IOException {
        laden("Worttrainer.txt");
    }
}