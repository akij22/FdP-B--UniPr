package it.unipr.elezioni;

import java.util.*;

public class Elezione {
	
	private Vector<Eleggibile> partecipanti;

	
	public Elezione() {
		this.partecipanti = new Vector<Eleggibile>();
	}
	
	
	public void add(Eleggibile other) {
		
		if (this.partecipanti.contains(other)) throw new RuntimeException("Partito o coalizione gia' presente!");
		
		if (other instanceof Partito) {
			
			for (Eleggibile elem : this.partecipanti) {
				if (elem instanceof Coalizione) {
					if (((Coalizione) elem).getPartiti().contains(other))
						throw new RuntimeException("Partito gia' presente in una coalizione gia' iscritta!");
				}
			}
		} else if (other instanceof Coalizione) {
			for (Partito p : ((Coalizione) other).getPartiti()) {
				if (this.partecipanti.contains(p))
					throw new RuntimeException("Coalizione contiene partito gia' iscritto!");
			}
		}
		
		
		this.partecipanti.add(other);
	}
	
	
	public Eleggibile winner() {
		
		
		int maxVoti = 0;
		Eleggibile finalElem = this.partecipanti.firstElement();
		
		for(Eleggibile elem : this.partecipanti) {
			
			if (elem.getVoti() >= maxVoti) {
				maxVoti = elem.getVoti();
				finalElem = elem;
			}
			
		}
		
		return finalElem;
	}
}
