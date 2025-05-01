package it.unipr.lavoratori;

public class MainLavoratori {

	public static void main(String[] args) {
		Lavoratore l1 = new Lavoratore("Achille", "MEDIO", 1000);
		Lavoratore ll1 = new Lavoratore("Achille", "MEDIO", 1000);
		Lavoratore l2 = new Lavoratore("Giorgio", "MEDIO", 1000);
		
		System.out.println(l1.equals(l2));
		
		System.out.println("Stipendio lavoratore 1: " + l1.getStipendio());
		
		LavoratoreConStraordinari ls1 = new LavoratoreConStraordinari("Mario", "AVANZATO", 2000, 5);
		LavoratoreConStraordinari ls2 = new LavoratoreConStraordinari("Giorgio", "MEDIO", 1000, 5);
		
		System.out.println(ls1.getStipendio());
		
		System.out.println(l1.equals(ll1));
		
		
		
		

	}

}
