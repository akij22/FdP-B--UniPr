package prenotazioneaulee;

public class Test {

	public static void main(String[] args) {
		AulaStandard a1 = new AulaStandard("Aula1", 100, 22);
		
		AulaStandard a2 = new AulaStandard("Aula1", 104, 22);
		
		SistemaPrenotazioni s1 = new SistemaPrenotazioni();
		
		
		Prenotazione p1 = new Prenotazione(a1, "data1");
		Prenotazione p2 = new Prenotazione(a1, "data1");
		Prenotazione p3 = new Prenotazione(a2, "data3");
		
		
		
		s1.aggiungiPrenotazione(p1);
		s1.aggiungiPrenotazione(p3);
		s1.aggiungiPrenotazione(p1);
		
		
		

	}

}
