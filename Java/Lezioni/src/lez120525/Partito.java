package lez120525;

import java.util.Objects;

public class Partito implements Eleggibile, Cloneable {
	private final String nome;
	private int voti;
	
	
	
	private Partito(String nome, int voti) {
		
		Objects.requireNonNull(nome);
		
		if (nome.isEmpty())
			throw new RuntimeException();
		
		
		this.nome = nome;
		
		Objects.requireNonNull(voti);
		
		if (voti < 0)
			throw new RuntimeException();
		
		this.voti = voti;
	}
	
	public Partito(String nome) {
		
		Objects.requireNonNull(nome);
		
		
		if (nome.isEmpty()) {
			throw new RuntimeException();
		}
		
		this.nome = nome;
		this.voti = 0;
	}
	

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public int getVoti() {
		return this.voti;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, voti);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		
		Partito other = (Partito) obj;
		
		return this.nome.equals(other.nome) && this.voti == other.voti;
	}
	
	
	@Override
	public Object clone() {
		
		
		// Richiama un COSTRUTTORE PRIVATO
		return new Partito(nome, voti);
	}
	
	
	
	

}
