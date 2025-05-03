package it.unipr.multiset;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Multiset<T extends Comparable<T>>
	implements Iterable<T>{
	private Vector<T> elements;
	
	public Multiset() {
		this.elements = new Vector<T>();
	}
	
	
	public void add(T elem) {
		this.elements.add(elem);
	}
	
	public boolean isPresent(T other) {
		if(this.elements.isEmpty()) {
			throw new RuntimeException("Multiset vuoto!");
		}
		
		for(T elem : elements) {
			if (elem.equals(other))
				return true;
		}
		
		return false;
	}
	
	public void remove(T other) {
		
		if (!this.elements.isEmpty()) {
			
			if(this.isPresent(other))
				
				this.elements.remove(other);
			
			else throw new IllegalArgumentException();
			
		} else throw new RuntimeException("Multiset vuoto!");
		
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (other == this) return true;
		
		if (other == null || this.getClass() != other.getClass()) return false;
		
		// Downcasting
		Multiset<T> o = (Multiset<T>) other;
		
		Vector<T> thisOrder = this.order();
		Vector<T> otherOrdered = o.order();
		
		if (thisOrder.equals(otherOrdered)) return true;
		else return false;
		
		
	}
	
	
	// Ordinamento di vettori from scratch
	public Vector<T> order(){
		Vector<T> vectorOrdered = this.elements;
		
		for (int i = 0; i < vectorOrdered.size() - 1; i++) {
			for (int j = 0; j < vectorOrdered.size() - i - 1; j++) {
				
				// Confronto
				if (vectorOrdered.get(j).compareTo(vectorOrdered.get(j + 1)) > 0 ) {
					
					// Swap
					T temp = vectorOrdered.get(j);
					vectorOrdered.set(j, vectorOrdered.get(j + 1));
					vectorOrdered.set(j + 1, temp);
					
				}
			}
		}
		
		return vectorOrdered;
	}
	
	
	
	@Override
	public Iterator<T> iterator(){
		
		// Classe Vector<T> implementa di default
		// l'interfaccia Iterator
		return elements.iterator();
	}
	
}
