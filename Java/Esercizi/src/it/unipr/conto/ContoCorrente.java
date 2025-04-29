package it.unipr.conto;

public class ContoCorrente {
	
	private static int globalnumeroContoCorrente = 0;
	
	private String nomeIntestatario;
	private String cognomeIntestatario;
	private int numeroConto;
	
	private double saldoResiduo;
	
	
	public ContoCorrente() {
		this("", "", 0);
	}
	
	public ContoCorrente(String nome, String cognome, double saldoIniziale) {
		
		globalnumeroContoCorrente++;
		
		this.nomeIntestatario = nome;
		this.cognomeIntestatario = cognome;
		
		if (saldoIniziale < 0)
			throw new RuntimeException("Saldo iniziale non valido!");
		
		this.saldoResiduo = saldoIniziale;
		
		this.numeroConto = globalnumeroContoCorrente;
		
	}
	
	
	public void deposita(double cash) {
		if (cash < 0)
			throw new RuntimeException("Soldi cash non validi!");
		
		this.saldoResiduo = this.saldoResiduo + cash;
		System.out.println("Cash versato correttamente!");
	}
	
	public void preleva(double withdraw) {
		if (this.saldoResiduo < withdraw)
			throw new RuntimeException("Non hai abbastanza soldi sul conto!");
		
		this.saldoResiduo = this.saldoResiduo - withdraw;
		System.out.println("Soldi prelevati correttamente");
	}
	
	public static int getNumeroConto() {
		return globalnumeroContoCorrente;
	}
	
	
	public String toString() {
		return "Intestatario: " + this.nomeIntestatario + " " + this.cognomeIntestatario + ", numero conto: " + this.numeroConto + ", saldo residuo: " + this.saldoResiduo;
	}
	

}
