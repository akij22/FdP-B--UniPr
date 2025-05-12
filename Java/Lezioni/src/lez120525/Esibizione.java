package lez120525;

import java.util.Objects;

public class Esibizione {

	private final Partecipante partecipante;
	private final String dataEOra;
	
	
	public Esibizione(Partecipante partecipante, String dataOra) {
		
		Objects.requireNonNull(partecipante);
		Objects.requireNonNull(dataOra);
		
		if (dataOra.isEmpty())
			throw new IllegalArgumentException();
		
		
		this.partecipante = partecipante;
		this.dataEOra = dataOra;
	}
	
	
	public Partecipante getPartecipante() {
		return this.partecipante;
	}
	
	public String getDataEOra() {
		return this.dataEOra;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dataEOra, partecipante);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Esibizione other = (Esibizione) obj;
		return Objects.equals(dataEOra, other.dataEOra) && Objects.equals(partecipante, other.partecipante);
	}
	
	
	
}
