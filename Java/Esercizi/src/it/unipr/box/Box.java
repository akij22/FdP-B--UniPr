package it.unipr.box;

import java.util.Vector;

public class Box<T extends Comparable<T>> {
	
	private Vector<T> elements;

	
	
	public Box() {
		this.elements = new Vector<T>();
		// this.counter = 0;
	}
	
	public void add(T elem) {
		
		elements.add(elem);
	}
	
	public void remove(T toRemove){ 
		
		if (!this.elements.isEmpty())
			this.elements.remove(toRemove);

		else 
			throw new RuntimeException("Nessun elemento presente!");
	}
	
	public int getSize() {
		return this.elements.size();
	}
	
	public boolean isPresent(T elem) {
		
		if(!this.elements.isEmpty()) {
			for(T e : elements) {
				if (e.equals(elem))
				return true;
			}
			return false;
			
		} else throw new RuntimeException("Nessun elemento presente!");
		

	}
	
	
	public T greatest() {
		
		if (!this.elements.isEmpty()) {
			
			T g = this.elements.firstElement();
			for (T elem : elements) {
				if (elem.compareTo(g) > 0) {
					g = elem;
				}
			}
			return g;
			
		} throw new RuntimeException("Nessun elemento presente!");
		
	}

	
	

}
