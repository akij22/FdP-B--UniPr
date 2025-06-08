package it.unipr.esamiestudenti;

import java.util.Objects;

public class StudenteOrdinario implements Immatricolabile {

	
	private String matricola;
	private String nomeScuola;
	
	public String getMatricola() {
		return this.matricola;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		StudenteOrdinario other = (StudenteOrdinario) o;
		
		return this.matricola.equals(other.matricola);
	}
	
	
	public int hashCode() {
		return Objects.hash(this.matricola, this.nomeScuola);
	}
}
