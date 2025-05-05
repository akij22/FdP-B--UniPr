package tut050525;

public class ProdottoFisico implements Catalogabile {

	private double peso;
	private String dimensioni;
	private String ID;
	private String descrizione;
	private double valore;
	
	
	public ProdottoFisico(String ID, String descrizione, double valore, String dimensioni, double peso) {
		this.ID = ID;
		this.descrizione = descrizione;
		this.valore = valore;
		this.dimensioni = dimensioni;
		this.peso = peso;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
			
			ProdottoFisico other = (ProdottoFisico) o;
		
		return this.ID.equals(other.ID);
	}
	
	
	
	// Quando si ridefinisce equals, è buona norma ridefinire anche hashCode
	public int hashCode() {
		return this.ID.hashCode();
	}
	
	@Override
	public String getCodiceUnivoco() {
		return this.ID;
	}

	@Override
	public String getDescrizione() {
		return this.descrizione;
	}
	

	@Override
	public double getValore() {
		return this.valore;
	}

}
