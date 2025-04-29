package lez02;


public class ArrayUtility {
	
	public static <T> boolean compare(T[] x, T[] y) {
		
		if (x == null || y == null)
			return false;
		
		if(x.length != y.length)
			return false;
		
		for (int i = 0; i < x.length; i++) {
			
			
			if (!x[i].equals(y[i]))
				return false;
		}
		return true;
	}
	
	
	
	public static <T> boolean search(T[] x, T elem) {
		
		if (x == null)
			return false;
		
		for (int i = 0; i < x.length; i++)
			if (x[i].equals(elem))
				return true;
		
		return false;
	}
	
	
	
	public static <T extends Comparable<T>> T max(T[] x){
		if (x == null)
			return null;
		
		T max = x[0];
		
		for (int i = 0; i < x.length; i++) {
			if (x[i].compareTo(max) > 0)
				max = x[i];
		}
		return max;
		
		
	}
	
	
	

}
