package it.unipr.biblioteca;

public abstract class ElementoBibliografico {
	
	protected String titolo;
	
	public ElementoBibliografico() {
		this.titolo = "";
	}
	
	public abstract float getCosto();
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		ElementoBibliografico other = (ElementoBibliografico) o;
		
		return this.titolo.equals(other.titolo);
	}
	
	
}
