package lez02;

public class Messaggio {
	
	private final String autore;
	private final String messaggio;
	
	public Messaggio(String autore, String messaggio) {
		this.autore = autore;
		this.messaggio = messaggio;
	}
	
	public String toString() {
		return this.autore + ", " + this.messaggio;
	}

}
