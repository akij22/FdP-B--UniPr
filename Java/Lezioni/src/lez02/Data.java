package lez02;

public class Data {
	
	private int giorno;
	private int mese;
	private int anno;
	
	Data () {
		
		// Delega al costruttore con parametri
		// Utilizzo this come metodo
		this(1, 1, 1970);
	}
	
	
	
	private boolean valida(int giorno, int mese, int anno) {
		return giorno > 0 && giorno <= 31 && mese > 0 && mese <= 12;
	}
	
	
	Data (int giorno, int mese, int anno){
		if (valida(giorno, mese, anno)) {
			this.giorno = giorno;
			this.mese = mese;
			this.anno = anno;
		
		} else {
			this.giorno = 1;
			this.mese = 1;
			this.anno = 1970;
		}
	}
	
	public boolean equals(Object obj) {
		
		return true;
	}
	
	public void print() {
		System.out.println(this.giorno + " / " + this.mese + " / " + this.anno);
	}
	
	
	// Ridefinisco un metodo che mi permette di stampare l'oggetto come stringa
	public String toString() {
		return giorno + " / " + mese + " / " + anno;
	}
	
	public static void main(String[] args) {
		
		Data d1;
		d1 = new Data();
		
		Data d2 = new Data();
		
		// d.print();
		System.out.println(d1);
		
		// Controllo le reference, NON gli oggetti
		System.out.println(d1 == d2);
		
		
		
	}
	

}
