package it.unipr.elezioni02;

import java.util.Objects;

public abstract class Eleggibile {
	
	protected String nome;
	protected int nVoti;
	
	public Eleggibile(String nome, int nVoti) {
		this.nome = nome;
		this.nVoti = nVoti;
	}
	
	protected Eleggibile (String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getNVoti() {
		return this.nVoti;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(nVoti, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleggibile other = (Eleggibile) obj;
		return nVoti == other.nVoti && Objects.equals(nome, other.nome);
	}
	
	
	
	
	
	

}
