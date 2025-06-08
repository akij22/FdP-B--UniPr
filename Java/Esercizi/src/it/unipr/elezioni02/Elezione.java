package it.unipr.elezioni02;

import java.util.*;

public class Elezione {
	
	private Set<Coalizione> coalizioni;
	
	public Elezione() {
		this.coalizioni = new HashSet<Coalizione>();
	}
	
	public void add(Coalizione other) {
		if (this.coalizioni.contains(other)) throw new RuntimeException();
		
		this.coalizioni.add(other);
	}
	
	
	public Coalizione winner() {
		
		int maxV = 0;
		Coalizione win = null;
		
		if (this.coalizioni.isEmpty()) return null;
		
		for (Coalizione c : this.coalizioni) {
			if (c.getNVoti() >= maxV) {
				maxV = c.getNVoti();
				win = c;
			}
		}
		
		return win;
	}
	
	

}
