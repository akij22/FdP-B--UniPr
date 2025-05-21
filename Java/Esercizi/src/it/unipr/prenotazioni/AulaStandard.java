package it.unipr.prenotazioni;

import java.util.Objects;

public class AulaStandard extends Aula {
	
	private int nLavagne;
	
	public AulaStandard() {
		super();
		this.nLavagne = 0;
	}
	
	public AulaStandard(String nome, int c, int l) {
		super(nome, c);
		this.nLavagne = l;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nLavagne);
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (!super.equals(o) || this.getClass() != o.getClass()) return false;
		
		AulaStandard other = (AulaStandard) o;
		
		return super.equals(other) && this.nLavagne == other.nLavagne;
	}
	


}
