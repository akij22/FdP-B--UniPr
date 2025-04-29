package esercizi;

public class Aereo {
	
	private static int nVoli = 0;
	
	private String stato;
	
	
	Aereo(){
		this("decollo");
	}
	
	Aereo (String stato){
		if (stato.equals("decollo") || stato.equals("crociera") ||
				stato.equals("atterraggio") || stato.equals("atterrato")) {
		
			this.stato = stato;
			nVoli++;
			
		} else
		throw new RuntimeException("Stato non valido!");
		
		
	}
	
	public void crociera() {
		if (this.stato.equals("decollo")) {
			this.stato = "croicera";
			return;
		}
		
		throw new RuntimeException("Non puoi effettuare crociera se non sei in decollo!");
	}
	
	public void atterraggio() {
		if (this.stato.equals("crociera")) {
			this.stato = "atterraggio";
			return;
		}
		
		throw new RuntimeException("Non puoi effettuare atterraggio se non sei in crociera!");
	}
	
	public void atterrato() {
		if (this.stato.equals("atterraggio")) {
			this.stato = "atterrato";
			return;
		}
		
		throw new RuntimeException("Non puoi atterrare se non sei in atterraggio!");
	}
	
	public static int getNVoli() {
		return nVoli;
	}
	

}
