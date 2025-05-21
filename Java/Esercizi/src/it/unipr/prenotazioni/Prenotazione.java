package it.unipr.prenotazioni;

public class Prenotazione {

	private Aula aula;
	private String data;
	
	
	public Prenotazione(Aula aula, String data) {
		this.aula = aula;
		this.data = data;
	}
	
	public Aula getAula() {
		return this.aula;
	}
	
	public String getData() {
		return this.data;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Prenotazione other = (Prenotazione) o;
		
		return this.aula == other.aula && this.data.equals(other.data);
	}
	
	
	
}
