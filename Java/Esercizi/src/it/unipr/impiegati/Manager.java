package it.unipr.impiegati;

import java.util.*;

public class Manager extends Impiegato implements Comparable<Manager>, Iterable<Impiegato> {
	
	private static double stipendio = 25.90;
	
	
	private Set<ImpiegatoBase> team;
	
	public Manager(String nome, String cognome, int oreLavoroAnnue) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.oreLavoroAnnue = oreLavoroAnnue;
		
		this.team = new HashSet<ImpiegatoBase>();
	}
	
	
	public static double getStipendio() {
		return stipendio;
	}
	
	public double getStipendioAnnuale() {
		return this.getOreLavoroAnnue() * Manager.getStipendio();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass()!= o.getClass()) return false;
		
		Manager other = (Manager) o;
		
		return super.equals(other) && this.team.equals(other.team);	
		
	}
	
	
	public void AggiungiAlTeam(Impiegato other) throws Exception {
		
		if (other.getOreLavoroAnnue() >= 20 && !(other instanceof Manager) && !this.team.contains(other)) {
			this.team.add((ImpiegatoBase) other);
			
			System.out.println("Membro aggiunto al team!");
		} else throw new Exception();
	}
	
	
	public int compareTo(Manager other) {
		return Integer.compare(this.team.size(), other.team.size());
	}
	
	public Iterator<Impiegato> iterator() {
		return (Iterator<Impiegato>) ((Impiegato) this.team.iterator());
	}
	
	
	
	

}
