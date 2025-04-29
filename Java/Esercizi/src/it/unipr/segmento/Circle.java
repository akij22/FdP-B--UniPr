package it.unipr.segmento;

public class Circle extends Pointer {
	private double raggio;
	
	public Circle() {
		super(0, 0);
		this.raggio = 1;
	}
	
	public Circle(int x, int y, double raggio) {
		super(x, y);
		
		if(raggio > 0)
			this.raggio = raggio;
		else throw new RuntimeException("Valore del raggio non valido!");
	}
	
	
	public Circle(int x, int y) {
		super(x, y);
		this.raggio = 1;
	}
	
	public double getRaggio() {
		return this.raggio;
	}
	
	public void visualizzaDettagli() {
		super.visualizzaDettagli();
		
		System.out.println("Raggio: " + this.getRaggio());
	}
	
	public void scalaCerchio(int quantity) {
		this.moveToX(quantity);
		this.moveToY(quantity);
		
		this.raggio = this.raggio * quantity;
	}
	
	public boolean equals(Circle other) {
		return super.equals(other)
				&& this.getRaggio() == other.getRaggio();
	}
	
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")" + ", " + this.getRaggio();
	}

}
