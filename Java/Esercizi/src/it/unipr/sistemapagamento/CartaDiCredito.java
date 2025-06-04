package it.unipr.sistemapagamento;

public class CartaDiCredito implements MetodoPagamento, Comparable<CartaDiCredito>{

	
	private String numeroCarta;
	private double saldo;
	
	public CartaDiCredito(String numeroCarta, double saldo) {
		this.numeroCarta = numeroCarta;
		
		if (saldo < 0)
			throw new IllegalArgumentException("Valore del saldo non valido!");
		this.saldo = saldo;
	}
	
	
	
	public double verificaSaldo() {
		return this.saldo;
	}
	
	public void incrementa(double value) {
		
		this.saldo += value;
	}
	
	public void decrementa(double value) {
		
		if (value > this.saldo)
			throw new SaldoNonSufficienteException("Saldo non sufficiente per la transazione!");
		this.saldo -= value;
		
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		CartaDiCredito other = (CartaDiCredito) o;
		
		return this.numeroCarta.equals(other.numeroCarta) && this.saldo == other.saldo;
	}
	
	public int compareTo(CartaDiCredito other) {
		return Double.compare(this.saldo, other.saldo);
	}
	
}
