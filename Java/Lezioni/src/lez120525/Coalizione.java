package lez120525;

import java.util.*;

public class Coalizione implements Eleggibile{
	
	private final String nome;
	private final Set<Partito> partiti;
	
	
	public Coalizione(String nome, Partito[] partiti) {
		
		this.nome = nome;
		
		this.partiti = new HashSet<Partito>();
		
		for (int i = 0; i < partiti.length; i++) {
			if (!this.partiti.contains(partiti[i])) {
				
				this.partiti.add(partiti[i]);
			}
		}
	}
	
	
	@Override
	public String getNome() {
		return this.nome;
	}
	@Override
	public int getVoti() {
		
		int finalVoti = 0;
		
		for (Partito p : this.partiti) {
			
			finalVoti += p.getVoti();
			
		}
		
		return finalVoti;
	}
	
	
	public String toString() {
		return this.getNome();
	}
	
	
	public Set<Partito> getPartiti(){
		
		// Return di una copia dell'hashset originale della classe
		return new HashSet<>(this.partiti);
		
		// return Collections.unmodifiableSet(this.partiti);
	}

}
