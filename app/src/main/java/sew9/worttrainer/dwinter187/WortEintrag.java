package sew9.worttrainer.dwinter187;

public class WortEintrag {
    private String wort;

	private String url;

	/**
	 * erstellt einen Worteintrag
	 * @param wort das Wort
	 * @param url die Url 
	 */
	public WortEintrag(String wort, String url) {
		this.wort=wort;
		this.url=url;
	}

	/**
	 * checkt die URL nach gültigkeit
	 * @param url die URL die gecheckt werden soll
	 * @return ob die URL gültig ist
	 */
	public static boolean checkUrl(String url) {                    //Methode um die URL zu checken
		if(url!=null){
			if(url.substring(0, 7).equals("http://") || url.substring(0, 8).equals("https://")){
				for(int zaehler=0;zaehler<url.length();zaehler++){
					if(url.charAt(zaehler)=='.'){
						if((int)url.charAt(zaehler-1)<=90 && (int)url.charAt(zaehler-1)>=65 || (int)url.charAt(zaehler-1)>=97 && (int)url.charAt(zaehler-1)<=122){          //schaut ob URL nach URL regeln ist
							if((int)url.charAt(zaehler+1)<=90 && (int)url.charAt(zaehler+1)>=65 || (int)url.charAt(zaehler+1)>=97 && (int)url.charAt(zaehler+1)<=122){
								return true;
							}else{
								return false;
							}
						}else{
							return false;
						}
                        
					}
				}
				return false;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public void setWort(String wort) {          // schaut ob Wort passt
		if(wort.length()>=2){
			this.wort=wort;
		}
	}

	public void setUrl(String url) {
		if(checkUrl(url)){
			this.url=url;
		}
	}

	public String getWort() {
		return this.wort;
	}

	public String getUrl() {
		return this.url;
	}

	@Override
	public String toString() {                  
		return new String(this.wort+"; "+this.url);
		
	}
}
