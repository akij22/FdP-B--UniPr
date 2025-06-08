package it.unipr.prenotazioni;

import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SistemaPrenotazioni implements Iterable<Prenotazione>{

	private Vector<Prenotazione> prenotazioni;
	
	public SistemaPrenotazioni() {
		this.prenotazioni = new Vector<Prenotazione>();
	}
	
	public boolean isEmpty() {
		return this.prenotazioni.isEmpty();
	}
	
	public boolean contains(Prenotazione other) {
		
		if (this.isEmpty())
			return false;
		
		for(Prenotazione elem : this.prenotazioni) {
			if (elem.equals(other))
				return true;
		}
		
		return false;
	}
	
	public void add(Prenotazione other) {
		if (this.contains(other))
			throw new RuntimeException("Prenotazione gia' presente!");
		
		
		this.prenotazioni.add(other);
	}
	
	
	public Set<Aula> getAuleStandardPrenotateOn(String data) {
		
		Set<Aula> finalA = new HashSet<Aula>();
		
		if (this.prenotazioni.isEmpty()) return finalA;
		
		for (Prenotazione p : this.prenotazioni) {
			if (p.getAula() instanceof AulaStandard && p.getData().equals(data))
				finalA.add(p.getAula());
		}
		
		return finalA;
		
		

	}
	

	@Override
	public Iterator<Prenotazione> iterator() {
		return this.prenotazioni.iterator();
	}
}
