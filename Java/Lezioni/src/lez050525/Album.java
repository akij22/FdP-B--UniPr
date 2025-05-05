package lez050525;

import java.util.HashSet;
import java.util.Set;

public class Album {
	
	private final String nomeAlbum;
	
	private final Set<Figurina> figs;
	
	
	public Album(String nomeAlbum) {
		
		this.nomeAlbum = nomeAlbum;
		
		this.figs = new HashSet<Figurina>();
	}
	
	
	public void add(Figurina f) {
		
		if (this.figs.contains(f))
			throw new IllegalArgumentException();
		
		else if(f instanceof FigurinaSportiva) {
			
			int countFigSport = 0;
			
			for(Figurina ff : this.figs) {
				if (ff instanceof FigurinaSportiva)
					countFigSport++;
				
			}
			
			if (countFigSport == 100)
				throw new IllegalArgumentException();
			else 
				this.figs.add(f);
		}
	}

}
