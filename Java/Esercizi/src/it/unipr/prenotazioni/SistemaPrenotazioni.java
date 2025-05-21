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
	
	
	public Set<Prenotazione> getAuleStandardPrenotateOn(String data) {
		
		if(this.isEmpty())
			return null;
		
		Set<Prenotazione> finalSet = new HashSet<Prenotazione>();
		
		for (Prenotazione elem : this.prenotazioni) {
			if (elem.getData().equals(data))
				finalSet.add(elem);
		}
		
		return finalSet;
	}
	
	

	@Override
	public Iterator<Prenotazione> iterator() {
		return this.prenotazioni.iterator();
	}
}
