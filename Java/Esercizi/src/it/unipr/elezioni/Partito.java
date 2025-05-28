package it.unipr.elezioni;

import java.util.Objects;

public class Partito implements Eleggibile, Cloneable {
	
	private String nome;
	
	private int voti;
	
	
	public Partito(String nome) {
		this.nome = nome;
		this.voti = 0;
	}
	
	private Partito (String nome, int voti) {
		this.nome = nome;
		
		if (voti < 0)
			throw new IllegalArgumentException();
		
		this.voti = voti;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getVoti() {
		return this.voti;
	}
	
	
	public void vota() {
		this.voti += 1;
	}
	
	
	@Override
	public String toString() {
		return this.nome + " " + this.voti;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Partito other = (Partito) o;
		
		return this.nome.equals(other.nome) && this.voti == other.voti;
	}
	
	
	public int HashCode() {
		return Objects.hash(nome, voti);
	}
	
	
	public Partito clone() {
		return new Partito(this.nome, this.voti);
	}
	
	
	
	
	
	
	
	

}
