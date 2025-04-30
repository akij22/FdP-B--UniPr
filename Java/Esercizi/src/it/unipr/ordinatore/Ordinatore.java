package it.unipr.ordinatore;

public class Ordinatore<T extends Comparable<T>> {
	
	private T prevElement;
	
	public Ordinatore(T elem) {
		this.prevElement = elem;
	}
	
	
	
	T getPrevElem() {
		return this.prevElement;
	}
	
	
	int check(T elem) {
		
		int finalCode;
		
		if(this.prevElement.compareTo(elem) > 0) 
			finalCode = 1;
			
		 else if (this.prevElement.compareTo(elem) < 0) 
			finalCode = -1;
			
		 else
			 finalCode = 0;
		
		this.prevElement = elem;
		return finalCode;
	}

}
