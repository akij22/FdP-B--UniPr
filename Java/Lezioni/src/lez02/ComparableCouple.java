package lez02;

public class ComparableCouple<T extends Comparable<T>> extends Couple<T> 
	implements Comparable<ComparableCouple<T>>{

	
	public ComparableCouple(T first, T second) {
		super(first, second);
	}
	
	
	// Ridefinisco il metodo compareTo, dato che la classe
	// imolementa l'interfaccia Comparable
	public int compareTo(ComparableCouple<T> other) {
		int cmp = getFirst().compareTo(other.getFirst());
		if (cmp != 0)
			return cmp;
		return getSecond().compareTo(other.getSecond());
	}
}
