package it.unipr.sistemapagamento;

public class TestMain {

	public static void main(String[] args) {
		CartaDiCredito c1 = new CartaDiCredito("akidkj", 200);
		
		CartaDiCredito c2 = new CartaDiCredito("otherone", 10);
		
		Persona p1 = new Persona("Akille", "Rozzi");
		
		p1.aggiungiPagamento(c1);
		
		p1.paga(c1, 10);
		p1.paga(c2, 1000);

	}

}
