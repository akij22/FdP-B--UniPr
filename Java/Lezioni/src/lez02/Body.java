package lez02;

/*
 * 

* Si implementi in Java una classe Body che rappresenta 
* un corpo puntiforme dotato di massa, che cade soggetto 
* solo alla forza di gravità terrestre. 
* Il costruttore prende come parametro la massa del corpo e 
* la sua altezza iniziale. Si supponga che tutte le grandezze 
* siano espresse in unità tra loro omogenee (altezza in metri, 
* velocità in metri al secondo, etc.). Si implementi il metodo 
* progress che simula il passaggio di un certo numero di secondi. 
* Si implementi un metodo getString che ritorna una stringa che contiene 
* le informazioni riguardanti l'altezza dal suolo e la velocità corrente del corpo.

 * */


public class Body {
	
	
	
	private float massa;
	private float altezza;
	
	
	public Body(float massa, float altezzaIniziale) {
		if (massa > 0)
			this.massa = massa;
		
		if (altezzaIniziale > 0)
			this.altezza = altezzaIniziale;
		
	}
	
	public String toString() {
		double velocita = Math.sqrt(2 * 9.81 * altezza);
		return ("Altezza corrente dal suolo: " + this.altezza + "m, velocita' corrente del corpo: " + velocita + "km/h");
	}
	
	
	
	public void progress(float time) {
		
		if (this.altezza == 0) {
			System.out.println("L'oggetto ha gia raggiunto il suolo!");
			
			return;
		}
			
			
		this.altezza = this.altezza - (float)0.5 * (float)9.81 * (time * time);
		
		
		
		if(this.altezza <= 0) {
			System.out.println("L'oggetto ha toccato il suolo!");
			this.altezza = 0;
		}
		
		System.out.println("Altezza attuale: " + this.altezza);
		
		
		
	}
	
	
	void getString() {
		System.out.println(this.toString());
	}
	
	
	

	// MAIN DI TEST
	public static void main(String[] args) {
		
		Body b1 = new Body(10, 50);
				
		b1.getString();
		
		b1.progress(2);
	

	}

}
