package it.unipr.serietv;

public class Main {

	public static void main(String[] args) {
		Episode e1 = new Episode("Primo episodio", "Prima trama", null);
		Episode e2 = new Episode("Secondo", "Trama", null);
		Episode e3 = new Episode("Terzo", "trama", null);
		
		e1.setNextEpisode(e2);
		e2.setNextEpisode(e3);
		
		Serial s1 = new Serial("Prima serie tv", e1);
		Serial s2 = new Serial("Prima serie tv", e1);
		
		
		System.out.println(s1.toString());
		
		System.out.println(s1.equals(s2));

	}

}
