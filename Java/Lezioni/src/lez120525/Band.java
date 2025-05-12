package lez120525;

import java.util.Objects;

public class Band extends Partecipante {

	private final int nComponenti;
	
	
	public Band(String nome, int anniAttivita, int nComponenti) {
		super(nome, anniAttivita);
		
		if (nComponenti < 0) {
			throw new IllegalArgumentException();
			
		}
		
		this.nComponenti = nComponenti;
	}
	
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = super.hashCode();
		
		result = prime * result + Objects.hash(nComponenti);
		return result;
	}


	@Override
	public boolean equals(Object o) {
		
		if (this == o)
			return true;
		
		if (o == null || this.getClass() != o.getClass())
			return false;
		
		Band other = (Band) o;
		
		return super.equals(other) && this.nComponenti == other.nComponenti;
		
	}


	@Override
	public String getMotto() {
		return "...band";
	}
	
	
	
	
	
	
}
