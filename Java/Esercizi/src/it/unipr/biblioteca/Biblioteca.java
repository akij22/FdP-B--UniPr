package it.unipr.biblioteca;
import java.util.*;

public class Biblioteca implements Comparable<Biblioteca> {

	private Vector<ElementoBibliografico> disponibili;
	private Vector<ElementoBibliografico> prestati;
	
	public Biblioteca() {
		this.disponibili = new Vector<ElementoBibliografico>();
		this.prestati = new Vector<ElementoBibliografico>();
	}
	
	public void add (ElementoBibliografico other) {
		this.disponibili.add(other);
	}
	
	public void presta(ElementoBibliografico other) throws BibliotecaException {
		
		if (!this.disponibili.contains(other)) {
			throw new BibliotecaException("Elemento non presente nei disponibili!");
		}
		
		this.disponibili.remove(other);
		
		this.prestati.add(other);
		
		
	}
	
	
	public void restituisci(ElementoBibliografico other) throws BibliotecaException {
		if(!this.prestati.contains(other))
			throw new BibliotecaException("Elemento non presente nei prestati!");
		
		this.prestati.remove(other);
		this.add(other);
	}
	
	public int compareTo(Biblioteca other) {
		
		return Integer.compare(this.disponibili.size(), other.disponibili.size());
		
		
	}

}
