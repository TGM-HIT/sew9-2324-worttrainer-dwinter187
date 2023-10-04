package sew9.worttrainer.dwinter187;
/**
 * erstellt eine Wortliste
 * @author Daniel Winter
 * @version 14.11.21
 * 
 */
public class WortListe {

	private WortEintrag[] wortliste;

	public WortListe() {
		this.wortliste= new WortEintrag[1];
	}
	/**
	 * Added ein Wort in die Liste
	 * 
	 * 
	 * @param wort Das Wort das geadded werden soll
	 */
	public void addWort(WortEintrag wort) {                                     //added das Wort in die WortListe
		boolean abfrage=false;
		while(!abfrage){
			for(int zaehler=0;zaehler<this.wortliste.length;zaehler++){         //checkt ob ein Platz im Array ist
				if(this.wortliste[zaehler]==null){
					this.wortliste[zaehler]=wort;
					abfrage=true;
				}
			}
			if(!abfrage){                                                           //added das Wort in die WortListe
				WortEintrag[] xy=new WortEintrag[this.wortliste.length+1];
				for(int x=0;x<this.wortliste.length;x++){
					xy[x]=this.wortliste[x];
				}
				this.wortliste= xy;
				for(int zaehler2=0;zaehler2<this.wortliste.length;zaehler2++){      //added das Wort am ersten Platz
					if(this.wortliste[zaehler2]==null){
						this.wortliste[zaehler2]=wort;
						abfrage=true;
					}
				}
			}
		}
		
	}
	public WortEintrag[] getListe() {
		return wortliste;
	}
	public WortEintrag getWort(int index) {
		return this.wortliste[index];
	}

	public int getLength(){
		return this.wortliste.length;
	}
	/**
	 * deletet ein Wort in der Wortliste
	 * @param wort das Wort was gelöscht werden soll
	 * @return returnded ob Wort gelöscht wurde
	 */
	public boolean deleteWord(String wort) {                                        //deletet das Wort
		for(int index=0;index<this.wortliste.length;index++){
			if(this.wortliste[index].getWort().equals(wort)){
				this.wortliste[index]=null;
				return true;
			}
		}
		return false;
	}
	/**
	 * macht Liste als String
	 * @return returned die Liste als String
	 */
	@Override
	public String toString() {                                                      //macht WortListe zu String
		String zurück= new String("");
		for(int index=0;index<this.wortliste.length;index++){
			if(this.wortliste[index]!=null){
				zurück=zurück+this.wortliste[index].toString()+"\n";
			}
		}
		return zurück;
	}

}
