package it.unipr.sistemapagamento;

public interface MetodoPagamento {
	
	public double verificaSaldo();
	public void incrementa(double value);
	public void decrementa(double value);

}
