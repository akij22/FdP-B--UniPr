package it.unipr.conto;

public class ContoCorrenteMain {

	public static void main(String[] args) {
		ContoCorrente c1 = new ContoCorrente("Achille", "Rossi", 50);
		ContoCorrente c2 = new ContoCorrente("Fabri", "Fibra", 10000);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());;
		
		c1.deposita(1000);
		c1.preleva(500);
		c2.deposita(500);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		
		
		System.out.println("\numero conti totali: " + ContoCorrente.getNumeroConto());

	}

}
