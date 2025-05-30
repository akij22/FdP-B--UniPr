package it.unipr.elezioni;
import java.util.*;

public class Coalizione implements Eleggibile {

	private String nome;
	private Set<Partito> partiti;
	
	
	public Coalizione(String nome, Partito[] arrayPartiti) {
		
		this.nome = nome;
		
		this.partiti = new HashSet<Partito>();
		
		for(int i = 0; i < arrayPartiti.length; i++) {
			
			if (!this.partiti.contains(arrayPartiti[i])) {
				this.partiti.add(arrayPartiti[i]);
			}
		}
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public int getVoti() {
		
		int finalSum = 0;
		
		for (Partito elem : this.partiti) {
			finalSum += elem.getVoti();
		}
		
		return finalSum;
	}
	
	
	@Override
	public String toString() {
		return this.nome + this.getVoti();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Coalizione other = (Coalizione) o;
		
		return this.nome.equals(other.nome) && this.partiti.equals(other.partiti);
	}
	
	
	public Set<Partito> getPartiti(){
		
		return new HashSet<Partito>(this.partiti);
		
		
	}
	
	
	

	
	
}
