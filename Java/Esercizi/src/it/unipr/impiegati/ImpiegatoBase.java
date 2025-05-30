package it.unipr.impiegati;

public class ImpiegatoBase extends Impiegato {

	public static double stipendio = 15.50;
	
	
	
	public ImpiegatoBase (String nome, String cognome, int oreLavoroAnnue) {
		this.nome = nome;
		this.cognome = cognome;
		this.oreLavoroAnnue = oreLavoroAnnue;
	}

	
	
	public double getStipendioAnnuale() {
		
		
		
		return this.getOreLavoroAnnue() * stipendio;
	}
	
	
	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	
}
