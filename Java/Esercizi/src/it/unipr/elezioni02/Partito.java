package it.unipr.elezioni02;

public class Partito extends Eleggibile {
	
	
	public Partito(String nome) {
		super(nome, 0);
	}
	
	public void vota() {
		this.nVoti++;
	}
	
	

}
