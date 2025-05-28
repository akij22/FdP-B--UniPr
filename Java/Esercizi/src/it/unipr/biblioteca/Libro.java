package it.unipr.biblioteca;

import java.util.Objects;

public class Libro extends ElementoBibliografico {
	
	private final String autore;
	private final float costo;
	
	
	public Libro() {
		super();
		
		this.autore = "";
		this.costo = 0.0f;
	}
	




	@Override
	public boolean equals(Object o) {
		
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Libro other = (Libro) o;
		
		return super.equals(other) && this.autore.equals(other.autore);
	
	}




	@Override
	public float getCosto() {
		return this.costo;
	}

}
