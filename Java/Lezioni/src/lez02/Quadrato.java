package lez02;

public class Quadrato extends Rettangolo{
	
	public Quadrato() {
		super(0, 0);
	}
	
	
	public Quadrato(int lato) {
		super(lato, lato);
	}
	
	@Override
	public int perimetro() {
		
		return this.lato * 4;
	}

}
