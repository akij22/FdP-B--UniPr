package lez02;

import java.util.Vector;

public class Ascensore {
	
	private int pesoContenuto;
	private int pesoLimite; // Massimo peso consentito
	
	// Vector non ancora trattato
	private Vector<Pesabile> contenuto;
	
	public Ascensore(int pesoLimite) {
		this.pesoLimite = pesoLimite;
		this.pesoContenuto = 0;
		this.contenuto = new Vector<Pesabile>();
	}
	
	public void add(Pesabile obj) {
		contenuto.add(obj);
		this.pesoContenuto += obj.getPeso();
		
		if (this.pesoContenuto > this.pesoLimite)
			System.out.println("Peso limite raggiunto!");
		
		
	}
	
	
	public static void main(String[] args) {
		Ascensore a1 = new Ascensore(500);
		
		a1.add(new Persona());
		a1.add(new Persona());
		a1.add(new Persona());
		// a1.add(new OggettoInAscensore());
	}

}
