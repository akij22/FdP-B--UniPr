package it.unipr.impiegati;

public abstract class Impiegato {
	protected String nome;
	protected String cognome;
	protected int oreLavoroAnnue;
	
	public String getNome() {
		return this.nome;
	}
	
	
	public String getCognome() {
		return this.cognome;
	}
	
	public int getOreLavoroAnnue() {
		return this.oreLavoroAnnue;
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass()!= o.getClass()) return false;
		
		Impiegato other = (Impiegato) o;
		
		return this.nome.equals(other.nome) && this.cognome.equals(other.cognome) && this.oreLavoroAnnue == other.oreLavoroAnnue;
	}
	
	
	public abstract double getStipendioAnnuale();

}
