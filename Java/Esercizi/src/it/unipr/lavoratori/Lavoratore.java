package it.unipr.lavoratori;


public class Lavoratore {
	
	protected String nome;
	protected String livelloSpecializzazione;
	protected double stipendio;
	
	private static final double salarioMinimo = 600.00;
	
	
	public Lavoratore() {
		this("Undefined", "BASE", 600.00);
	}
	
	
	public Lavoratore(String nome, String livelloSpecializzazione, double stipendio) {
		
		this.nome = nome;
		
		if (livelloSpecializzazione.equals("BASE") || livelloSpecializzazione.equals("MEDIO") || livelloSpecializzazione.equals("AVANZATO")) {
			this.livelloSpecializzazione = livelloSpecializzazione;

		// TODO: Possibile gestione con custom exception, che estende Exception  
		} else throw new IllegalArgumentException();
		
		if (stipendio >= salarioMinimo)
			this.stipendio = stipendio;
		else throw new IllegalArgumentException();
	}
	
	
	// Restituisce lo stipendio ANNUALE del lavoratore
	public double getStipendio() {
		return this.stipendio * 12;
	}
	
	
	

//	public boolean equals(Lavoratore other) {
//		return this.nome.equals(other.nome) && this.livelloSpecializzazione.equals(other.livelloSpecializzazione)
//				&& this.stipendio == other.stipendio;
//		
//	}
	
	@Override
	public boolean equals(Object other) {
		
		// Se le reference sono uguali, ossia se sono lo stesso oggetto
		if (this == other) return true;
		
		if (other == null || other.getClass() != this.getClass()) return false;
		
		Lavoratore o = (Lavoratore) other;
		
		return this.nome.equals(o.nome) && this.livelloSpecializzazione.equals(o.livelloSpecializzazione)
				&& this.stipendio == o.stipendio;
		
	}
	
	@Override
	public String toString() {
		return this.nome + ", " + this.livelloSpecializzazione + ", " + this.stipendio;
	}
	
	public double getSalarioMinimo() {
		return salarioMinimo;
	}
	
	

}
