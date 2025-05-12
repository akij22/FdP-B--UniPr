package lez120525;

import java.util.Objects;

public abstract class Partecipante {
	private final String nome;
	private final int anniAttivita;
	
	
	// METODI
	public Partecipante(String nome, int anniAttivita) {
		
		Objects.requireNonNull(nome);
		
		if (nome.isEmpty())
			throw new IllegalArgumentException();
		
		this.nome = nome;
		
		if (anniAttivita < 0)
			throw new IllegalArgumentException();
		this.anniAttivita = anniAttivita;
	}
	
	public int getAnniAttivita() {
		return this.anniAttivita;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		
		
		if (o == null || this.getClass() != o.getClass())
			return false;
		
		
		Partecipante other = (Partecipante) o;
		
		return this.nome.equals(other.nome) && 
				this.anniAttivita == other.anniAttivita;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.nome, this.anniAttivita);
	}
	
	
	
	public abstract String getMotto();
	
	
	@Override
	public final String toString() {
		return this.getMotto();
	}
	
}
