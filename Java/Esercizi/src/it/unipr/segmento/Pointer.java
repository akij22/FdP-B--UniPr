package it.unipr.segmento;

public class Pointer {
	
	
	private static int allocazioni = 0;
	
	protected int x;
	protected int y;
	
	public Pointer() {
		x = 0;
		y = 0;
		allocazioni++;
	}
	
	public Pointer(int x, int y) {
		this.x = x;
		this.y = y;
		allocazioni++;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public static int getAllocazioni() {
		return allocazioni;
	}
	
	
	Pointer clone(Pointer other) {
		Pointer clone = new Pointer();
		
		clone.setX(other.getX());
		clone.setY(other.getY());
		
		return clone;
	}
	
	
	void moveToX(int dist) {
		this.x += dist;
	}
	
	void moveToY(int dist) {
		this.y += dist;
	}
	
	boolean equals(Pointer other) {
		return this.x == other.x && this.y == other.y;
	}
	
	void visualizzaDettagli() {
		System.out.println("Coordinate: " + this.getX() + ", " + this.getY());
	}



}
