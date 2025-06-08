package it.unipr.esamiestudenti;

import java.util.Objects;

public class StudenteLavoratore implements Immatricolabile {

	private String matricola;
	private String nomeAzienda;
	
	public String getMatricola() {
		return this.matricola;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		
		StudenteLavoratore other = (StudenteLavoratore) o;
		
		return this.matricola.equals(other.matricola) && this.nomeAzienda.equals(other.nomeAzienda);
	}
	
	
	public int hashCode() {
		return Objects.hash(this.matricola, this.nomeAzienda);
	}
	
	
}
