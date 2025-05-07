package it.unipr.daticlimatici;

public class ClimateTest {

	public static void main(String[] args) {
		
		ClimateData c1 = new ClimateData("Emilia Romagna", 15.00, 40000);
		ClimateData c2 = new ClimateData("Abruzzo", 19.00, 23000);
		AugmentedClimateData ac1 = new AugmentedClimateData("Napoli", 21, 34000, 99.8f);
		AugmentedClimateData ac2 = new AugmentedClimateData("Calabria", 21.9, 37000, 98.7f);
		
		ClimateDataProcessor cdp1 = new ClimateDataProcessor();
		
		cdp1.add(c1);
		cdp1.add(c2);
		cdp1.add(ac1);
		cdp1.add(ac2);
		
		
		
		
		System.out.println(cdp1.getMediaSeaLevel());

	}

}
