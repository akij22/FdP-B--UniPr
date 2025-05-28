package it.unipr.biblioteca;

public class Dvd extends ElementoBibliografico {

	private final String regista;
	public final float costo;
	
	public Dvd() {
		super();
		this.regista = "";
		this.costo = 0.0f;
	}
	
	
	public float getCosto() {
		return this.costo;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Dvd other = (Dvd) o;
		
		return super.equals(other) && this.regista.equals(other.regista);
	}
}
