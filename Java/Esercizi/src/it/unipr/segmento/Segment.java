package it.unipr.segmento;

public class Segment {
	
	private Pointer p1;
	private Pointer p2;
	
	public Segment() {
		this(null, null);
	}
	
	public Segment(Pointer p1, Pointer p2) {
		
		this.p1 = p1;
		this.p2 = p2;
	}
	
	
	
	public Pointer getP1() {
		return p1;
	}

	public void setP1(Pointer p1) {
		this.p1 = p1;
	}

	public Pointer getP2() {
		return p2;
	}

	public void setP2(Pointer p2) {
		this.p2 = p2;
	}

	Pointer getMidpoint() {
		Pointer mid = new Pointer();
		
		mid.setX((this.p1.getX() + this.p2.getX())/2);
		mid.setY((this.p1.getY() + this.p2.getY())/2);
		
		return mid;
	}
	
	
	public String toString() {
		return "Punto di inzio del segmento: " + p1.toString() + 
				", punto di fine del segmento: " + p2.toString();
	}
	
	Segment clone(Segment other) {
		Segment clone = new Segment();
		
		clone.setP1(other.getP1());
		clone.setP2(other.getP2());
		
		System.out.println("Clonazione avvenuta!");
		
		return clone;
	}
}
