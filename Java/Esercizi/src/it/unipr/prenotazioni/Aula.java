package it.unipr.prenotazioni;

import java.util.Objects;

public abstract class Aula implements Comparable<Aula> {
	
	private String nomeAula;
	private int capienzaMassima;
	
	public Aula() {
		this.nomeAula = "";
		this.capienzaMassima = 0;
	}
	
	public Aula(String nomeAula, int capienzaMassima) {
		this.nomeAula = nomeAula;
		
		if (capienzaMassima > 0)
			this.capienzaMassima = capienzaMassima;
		else throw new RuntimeException("Valore della capienza massima non valido!");
	}
	
	
	public String getNomeAula() {
		return this.nomeAula;
	}
	
	public int getCapienzaMassima() {
		return this.capienzaMassima;
	}


	@Override
	public int hashCode() {
		return Objects.hash(capienzaMassima, nomeAula);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		
		Aula other = (Aula) obj;
		return capienzaMassima == other.capienzaMassima && this.nomeAula.equals(other.nomeAula);
	}
	
	public int compareTo(Aula other) {
		if (this.getCapienzaMassima() < other.getCapienzaMassima()) return -1;
		if (this.getCapienzaMassima() > other.getCapienzaMassima()) return 1;
		return 0;
	}
	
	
	

}
