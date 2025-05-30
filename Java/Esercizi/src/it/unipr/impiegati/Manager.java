package it.unipr.impiegati;

import java.util.*;

public class Manager extends Impiegato implements Comparable<Manager>, Iterable<Impiegato> {
	
	public static double stipendio = 25.90;
	
	
	private Set<ImpiegatoBase> team;
	
	public Manager(String nome, String cognome, int oreLavoroAnnue) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.oreLavoroAnnue = oreLavoroAnnue;
		
		this.team = new HashSet<ImpiegatoBase>();
	}
	
	
	public double getStipendioAnnuale() {
		return this.getOreLavoroAnnue() * stipendio;
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
		if (this.team.size() < other.team.size()) return -1;
		
		if (this.team.size() > other.team.size()) return 1;
		
		return 0;
	}
	
	public Iterator<Impiegato> iterator() {
		return (Iterator<Impiegato>) ((Impiegato) this.team.iterator());
	}
	
	
	
	

}
