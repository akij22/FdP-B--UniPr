package lez02;

public class Rettangolo {
	
	protected int lato;
	protected int altezza;
	
	public Rettangolo() {
		this(0 , 0);
	}
	
	public Rettangolo(int lato, int altezza) {
		this.lato = lato;
		this.altezza = altezza;
	}
	
	public int perimetro() {
		return 2 * this.lato + 2 * this.altezza;
	}
	
	

}
