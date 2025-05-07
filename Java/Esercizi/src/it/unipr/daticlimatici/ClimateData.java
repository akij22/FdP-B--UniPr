package it.unipr.daticlimatici;

import java.util.Objects;

public class ClimateData {
	
	private final String regione;
	private final double temperaturaMediaAnnua;
	private final double emissioneAnidrideAnnua;
	
	
	
	// CONSTRUCTOR
	public ClimateData(String regione, double temperaturaMediaAnnua, double emissioneAnidrideAnnua) {
		
		this.regione = regione;
		
		if (temperaturaMediaAnnua <= 0)
			throw new ValoreNonPlausibileException("Valore della temperatura non valido!");
		
		else this.temperaturaMediaAnnua = temperaturaMediaAnnua;
		
		if (emissioneAnidrideAnnua <= 0) {
			throw new ValoreNonPlausibileException("Valore di emissione di anidride carbonica annua non valido!");
		} else this.emissioneAnidrideAnnua = emissioneAnidrideAnnua;
		
	}
	
	
	// GETTER
	public String getRegione() {
		return this.regione;
	}
	
	public double getTemperaturaMediaAnnua() {
		return this.temperaturaMediaAnnua;
	}
	
	
	public double getEmissioneAnidrideAnnua() {
		return this.emissioneAnidrideAnnua;
	}

	
	// HASHCODE AND EQUALS METHODS

	@Override
	public int hashCode() {
		return Objects.hash(emissioneAnidrideAnnua, regione, temperaturaMediaAnnua);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ClimateData other = (ClimateData) obj;
		
		return Double.doubleToLongBits(this.emissioneAnidrideAnnua) == Double.doubleToLongBits(other.emissioneAnidrideAnnua)
				&& this.regione.equals(other.regione) && Double.doubleToLongBits(this.temperaturaMediaAnnua) == Double
						.doubleToLongBits(other.temperaturaMediaAnnua);
	}
	
	
	@Override
	public String toString() {
		return this.getRegione() + " " + this.getEmissioneAnidrideAnnua() + " " + this.getTemperaturaMediaAnnua();
	}
	
	
	
	
	

}
