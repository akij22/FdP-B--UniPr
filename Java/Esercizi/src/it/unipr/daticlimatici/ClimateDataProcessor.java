package it.unipr.daticlimatici;

import java.util.HashSet;
import java.util.Set;

// TODO
public class ClimateDataProcessor {
	
	private Set<ClimateData> climateDataCollect;
	
	
	public ClimateDataProcessor() {
		this.climateDataCollect = new HashSet<ClimateData>();
	}
	
	
	public void add(ClimateData other) {
		
		if (this.contains(other)) {
			throw new IllegalArgumentException("Dato climatico gia' presente nella collezione!");
		}
		
		this.climateDataCollect.add(other);
	}
	
	
	public boolean isEmpty() {
		return this.climateDataCollect.isEmpty();
	}
	
	
	public boolean contains(ClimateData other) {
		return this.climateDataCollect.contains(other);
	}
	
	public float getMediaSeaLevel() {
		
		
		if (this.isEmpty()) {
			return 0;
		}
		
		
		float finalSum = 0;
		int count = 0;
		
		for (ClimateData elem: this.climateDataCollect) {
			
			if (elem instanceof AugmentedClimateData) {
				finalSum += ((AugmentedClimateData) elem).seaLevel();
				count++;
			}
		}
		
		
		float finalAvg = finalSum / count;
		
		return finalAvg;
	}

}
