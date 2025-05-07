package it.unipr.daticlimatici;

import java.util.Objects;

public class AugmentedClimateData extends ClimateData implements SeaLevel {

	private final float seaLevel;
	
	
	public AugmentedClimateData(String regione, double temperaturaMediaAnnua, double emissioneAnidrideAnnua, float seaLevel) {
		
		super(regione, temperaturaMediaAnnua, emissioneAnidrideAnnua);
		
		if (seaLevel <= 0)
			throw new ValoreNonPlausibileException("Valore del livello del mare non valido!");
		else this.seaLevel = seaLevel;
		
	}
	

	@Override
	public float seaLevel() {
		return this.seaLevel;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(seaLevel);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (!super.equals(obj) || this.getClass() != obj.getClass())
			return false;
		
		
		AugmentedClimateData other = (AugmentedClimateData) obj;
		
		return super.equals(obj) && Float.floatToIntBits(seaLevel) == Float.floatToIntBits(other.seaLevel);
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " " + this.seaLevel();
	}
	
	
	
	
	
	
	

}
