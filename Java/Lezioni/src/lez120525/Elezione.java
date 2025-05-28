package lez120525;

import java.util.*;

public class Elezione {
	
	private final Set<Eleggibile> partecipanti;
	
	
	public Elezione() {
		this.partecipanti = new HashSet<>();
	}
	
	public void add(Eleggibile e) {
		
		if (this.partecipanti.contains(e))
			throw new RuntimeException();
		
		
		else if (e instanceof Partito) {
			for (Eleggibile p : this.partecipanti) {
				
				if (p instanceof Coalizione) {
					
					if(((Coalizione) p).getPartiti().contains(e))
						throw new RuntimeException();
				}
			}
		} else if (e instanceof Coalizione) {
			for (Partito p : ((Coalizione) e).getPartiti()) {
				if (this.partecipanti.contains(p)) {
					throw new RuntimeException();
				}
			}
		}
		
		
		this.partecipanti.add(e);
		
	}
	
	
	public Eleggibile winner() {
		int maxVoti = -1;
		
		Eleggibile max = null;
		
		for (Eleggibile e : this.partecipanti) {
			if (e.getVoti() >= maxVoti) {
				maxVoti = e.getVoti();
				max = e;
			}

		}
		
		return max;
	}
	
	
	

}
