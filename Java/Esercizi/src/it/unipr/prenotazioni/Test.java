package it.unipr.prenotazioni;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		AulaStandard a1 = new AulaStandard("aula 1", 120, 12);
		AulaStandard a2 = new AulaStandard("aula 1", 150, 123);
		
		Prenotazione p1 = new Prenotazione(a1, "12/02/2005");
		Prenotazione p2 = new Prenotazione(a1, "12/02/2005");
		Prenotazione p3 = new Prenotazione(a1, "12/02/2006");
		
		
		SistemaPrenotazioni sp1 = new SistemaPrenotazioni();
		sp1.add(p1);
		// sp1.add(p2);
		sp1.add(p3);
		
		Set<Prenotazione> finalHS = sp1.getAuleStandardPrenotateOn("12/02/2005");
		
		// System.out.println(finalHS);
		
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		
		
		
		
		

	}

}
