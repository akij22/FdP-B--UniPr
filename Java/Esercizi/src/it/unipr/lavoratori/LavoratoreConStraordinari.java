package it.unipr.lavoratori;

public class LavoratoreConStraordinari extends Lavoratore{

	private int oreStraordinario;
	
	private static final double retribuzioneOraria = 10.50;
	
	
	public LavoratoreConStraordinari() {
		this("Undefined", "BASE", 600.00, 0);
	}
	
	
	public LavoratoreConStraordinari(String nome, String livelloSpecializzazione, double stipendio, int oreStraordinaro) {
		super(nome, livelloSpecializzazione, stipendio);
		
		if (oreStraordinario >= 0)
			this.oreStraordinario = oreStraordinaro;
		else throw new IllegalArgumentException();
	}
	
	@Override
	public double getStipendio() {
		return this.stipendio * 12 + this.oreStraordinario * retribuzioneOraria;
	}
	
	
	@Override
	public String toString() {
		return this.nome + ", " + this.livelloSpecializzazione + ", " + this.stipendio + ", " + this.oreStraordinario;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		
		if (this.getClass() != other.getClass() || other == null) return false;
		
		LavoratoreConStraordinari l = (LavoratoreConStraordinari) other;
		
		
		// Richiamo il metodo della superclasse + aggiungo
		// check per la sottoclasse
		return super.equals(other) && this.oreStraordinario == l.oreStraordinario;
	}
}
