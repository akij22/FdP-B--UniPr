package it.unipr.sistemapagamento;

public class SaldoNonSufficienteException extends RuntimeException {

	public SaldoNonSufficienteException(String msg) {
		super(msg);
	}
}
