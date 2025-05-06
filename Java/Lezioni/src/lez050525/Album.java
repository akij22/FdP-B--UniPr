package lez050525;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Album implements Iterable<Figurina>{
	
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
	
	
	public Set<Figurina> getAllFigurineSportive(){
		
		HashSet<Figurina> result = new HashSet<>();
		
		for (Figurina f : this.figs) {
			
			// Inserico solo le figurine sportive
			if (f instanceof FigurinaSportiva)
				result.add(f);
		}
		
		
		return result;
	}
	
	
	// Returno un Set, per mantenere l'information hiding
	public Set<Figurina> getAllFigurineStoriche(){
		
		HashSet<Figurina> result = new HashSet<>();
		
		for (Figurina f : this.figs) {
			
			// Inserico solo le figurine sportive
			if (f instanceof FigurinaStorica)
				result.add(f);
		}
		
		
		return result;
	}


	@Override
	public int hashCode() {
		return Objects.hash(figs, nomeAlbum);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		
		return Objects.equals(figs, other.figs) && Objects.equals(nomeAlbum, other.nomeAlbum);
	}
	
	
	public boolean contains(Figurina other) {
		
		return this.figs.contains(other);
	}
	
	
	public void remove(Figurina other) {
		this.figs.remove(other);
	}
	
//	public void addFigurina(Figurina other) {
//		this.figs.add(other);
//	}


	@Override
	public Iterator<Figurina> iterator() {
		
		// Iteratore già implementato nel Set
		return this.figs.iterator();

	}
	

}
