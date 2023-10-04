package sew9.worttrainer.dwinter187;
import java.util.Random;
/**
 * Die Klasse die die Statistik der Eingaben verwaltet
 * @author Daniel Winter
 * 
 * @version 04.10.23
 */
public class WortTrainer {

	private WortListe wortliste;
	private int fragen;
	private int richtig;
	private int falsch;
	private int ungueltig;

	/**
	 * erstellt ein Worttraner Objekt
	 * @param wortListe die Wortliste mit der gearbeitet werden soll
	 */
	public WortTrainer(WortListe wortListe){
		this.wortliste=wortListe;
		this.fragen=0;
		this.richtig=0;
		this.falsch=0;
		this.ungueltig=0;
	}
	public WortTrainer(){
		this.wortliste=new WortListe();
		this.fragen=0;
		this.richtig=0;
		this.falsch=0;
		this.ungueltig=0;
	}
	
	public WortListe getWortListe() {
		return wortliste;
	}
	/**
	 * returned das Randomwort an einer random Stelle, falls kein Wort drinnen ist null
	 * @return das random Wort
	 */
	public WortEintrag getRandomWort() {						//returned ein Wort an einer random Stelle
		boolean x=true;
		Random r=new Random();
		int random= r.nextInt(this.wortliste.getLength());
		while(x){
			if(this.wortliste.getWort(random)!=null){
				return this.wortliste.getWort(random);
			}
		}
		return null;
	}

	public WortEintrag getWort(int index) {
		return this.wortliste.getWort(index);
	}

	/**
	 * checkt ob das Wort was eingegeben wurde richtig ist mit dem in der Liste
	 * @param wort das Wort was gecheckt werden soll
	 * @param index die Stelle des Wortes
	 * @return ob das Wort an der Stelle gleich ist
	 */
	public boolean check(String wort,int index) {				//checkt ob das Wort was eingegeben wurde richtig ist mit dem in der Liste
		this.fragen++;
		if(index>wortliste.getLength()-1){
			this.ungueltig++;
			return false;
		}
		if(this.wortliste.getWort(index).getWort().equals(wort)){
			this.richtig++;
			return true;
		}
		this.falsch++;
		return false;
	}
	/**
	 * macht das Selbe wie check aber ignoriert Groß- und Kleinschreibung
	 * @param wort das Wort was gecheckt werden soll
	 * @param index die Stelle des Wortes
	 * @return ob das Wort an der Stelle gleich ist
	 */
	public boolean checkIgnoreCase(String wort,int index) {					// wie check aber ignoriert Groß-Klein-Schriebung
		this.fragen++;
		if(index>wortliste.getLength()-1){
			this.ungueltig++;
			return false;
		}
		String vorlage= this.wortliste.getWort(index).getWort().toLowerCase();
		if(vorlage.equals(wort.toLowerCase())){
			this.richtig++;
			return true;
		}else{
			this.falsch++;
			return false;
		}
	}
	/**
	 * macht Ausgabe für die Fehlerquote
	 * @return dei Fehlerquote als Text
	 */
	public String getFehlerQuote(){					//gibt Fehlerquote aus
		String fehlerQuote= new String("Sie haben "+this.fragen+" Wörter geprüft. Davon waren "+this.richtig+" Wörter richtig und "+this.falsch+" Wörter falsch. "+this.ungueltig+" Ihrer Eingaben waren ungültig");
		return fehlerQuote;
	}
	public int getFragen(){
		return this.fragen;
	}
	public int getRichtige(){
		return this.richtig;
	}
	public int getFalsche(){
		return this.falsch;
	}
	public int getUngueltig(){
		return this.ungueltig;
	}
	public void addRichtige(int richtig){
		this.richtig += richtig;
	}
	public void addFalsche(int falsch){
		this.falsch += falsch;
	}

}

