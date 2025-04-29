package esercizi;

public class Main {

	public static void main(String[] args) {
		
		
		try {
			Aereo a1;
			a1 = new Aereo();
			
			Aereo a2 = new Aereo("crociera");
			
			a2.atterraggio();
			a2.atterrato();
			
		
		} catch(RuntimeException e) {
			System.out.println(e);
		}
		
		System.out.println(Aereo.getNVoli());

	}

}
