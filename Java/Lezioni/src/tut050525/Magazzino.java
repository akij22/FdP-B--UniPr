package tut050525;



// T estende interface Catalogabile
// --> accetto solo tipi T che implementano catalogabile
public class Magazzino<T extends Catalogabile> {

	private Catalogabile[] articoli;
	private int numeroArticoliPresenti;
	
	// Costante
	private static final int CAPACITY = 200;
	
	
	public Magazzino() {
		this.articoli = new Catalogabile[CAPACITY];
		this.numeroArticoliPresenti = 0;
	}
	
	
	// Return -1 se non l'ho trovato
	public int getArticoloIndex(String ID) {
		
		if (ID == null)
			return -1;
		
		for (int i = 0; i < this.numeroArticoliPresenti; i++) {
			if (articoli[i].getCodiceUnivoco() == ID)
				return i;
		}
		
		return -1;
		
	}
	
	public void addArticolo(T other) {
		if (other == null || other.getCodiceUnivoco() == null) throw new NullPointerException();
		
		
		if (this.getArticoloIndex(other.getCodiceUnivoco()) != -1)
			throw new IllegalArgumentException();
		
		if(this.numeroArticoliPresenti == CAPACITY)
			throw new RuntimeException("Capacita massima raggiunta!");
		
		this.articoli[this.numeroArticoliPresenti++] = other;
	}
	
	
	
	public boolean rimuoviArticolo(String codiceUnivoco) {
		
		if (codiceUnivoco == null)
			throw new IllegalArgumentException();
		
		int index = this.getArticoloIndex(codiceUnivoco);
		
		if (index == -1)
			return false;
		
		// Shift degli elementi per rimuovere quello con l'indice indicato
		for(int i = index; i < this.numeroArticoliPresenti - 1; i++) {
			this.articoli[i] = articoli[i + 1];
		}
		this.numeroArticoliPresenti--;
		
		return true;
		
	}
	
	
	public T findArticolo(String codiceUnivoco) {
		if (codiceUnivoco == null)
			throw new IllegalArgumentException();
		
		
		// Trovo l'indice dell'elemento che possiede il codice passato come parameter
		int index = this.getArticoloIndex(codiceUnivoco);
		
		if (index == -1)
			throw new IllegalArgumentException();
		
		return (T) this.articoli[index];
	}
	
	public double calcolaValoreTotale() {
		
		double finalSum = 0.0;
		
		for (Catalogabile elem : this.articoli) {
			
			finalSum += elem.getValore();
		}
		
		return finalSum;
	}
}
