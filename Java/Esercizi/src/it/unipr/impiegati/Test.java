package it.unipr.impiegati;

public class Test {

	public static void main(String[] args) throws Exception {
		ImpiegatoBase b1 = new ImpiegatoBase("Achille", "Rossi", 50);
		
		ImpiegatoBase b2 = new ImpiegatoBase("Yes", "Sir", 19);
		
		
		Manager m1 = new Manager("first", "manager", 51);
		
		m1.AggiungiAlTeam(b1);
		// m1.AggiungiAlTeam(b2);
		m1.AggiungiAlTeam(m1);
		

	}

}
