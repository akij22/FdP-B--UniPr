package lez02;

public class Couple<T extends Comparable<T>> {
	private T first;
	private T second;
	
	
	public Couple(T first, T second) {
		if (first == null || second == null)
			throw new NullPointerException();
		
		this.first = first;
		this.second = second;
	}
	
	
	public T getFirst() {
		return this.first;
	}
	
	public T getSecond() {
		return this.second;
	}
	
	@Override
	public String toString() {
		return "(" + this.first.toString() + ", " + this.second.toString() + ")";
	}
	
	public T greatest() {
		if (this.first.compareTo(this.second) > 0)
			return this.first;
		
		return this.second;	

	}
	
	public static void main(String[] args) {
		Couple<Integer> c1 = new Couple<Integer>(1, 15);
		Couple<String> c2 = new Couple<String>("Stringa1", "Stringa2");
	}
}
