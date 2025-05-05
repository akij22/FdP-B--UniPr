package lez050525;

public abstract class Figurina implements Comparable<Figurina> {
	
	protected final int id;
	
	public Figurina(int id) {
		if (id <= 0) throw new IllegalArgumentException("Id figurina deve essere maggiore di zero!");
		
		this.id = id;
	}
	
	
	public int getId() {
		return this.id;
	}
	
	
	public boolean equals(Object other) {
		
		if (this == other) return true;
		
		if (other == null || this.getClass() != other.getClass()) return false;
		
		Figurina o = (Figurina) other;
		
		return this.id == o.id;
	}
	
	
	// Ha solo la signature, quindi deve essere abstract
	public abstract boolean isRare();
	
	
	public int compareTo(Figurina other) {
		
		return Integer.compare(this.id, other.id);
	}

}
