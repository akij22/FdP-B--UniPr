package it.unipr.contest;

import java.util.Vector;

public class Contest<T> {
	
	private Vector<T> objects;
	private Vector<Integer> votiObject;
	
	public Contest() {
		
		this.objects = new Vector<T>();
		votiObject = new Vector<Integer>();
	}
	
	
	public void add(T obj) {
		
		this.objects.add(obj);
		this.votiObject.add(0);
	}
	
	
	public boolean isPresent(T obj) {
		return this.objects.contains(obj);
	}
	
	
	// Da specificare nella signature, dato che è una checked exception
	public void vote(T obj) throws ContestException {
		
		if (!this.objects.isEmpty()) {
			
			if (this.isPresent(obj)) {
				
				int index = this.objects.indexOf(obj);
				int value = this.votiObject.get(index);
				this.votiObject.set(index, value + 1);
				
			} else throw new ContestException();
			
		} else throw new RuntimeException("Non sono presenti elementi!");
	}
	
	public int getMaxValue() {
		
		if (!this.votiObject.isEmpty()) {
			
			int max = this.votiObject.firstElement();
			for(int elem : this.votiObject) {
				
				if (elem > max)
					max = elem;
			}
			return max;
		} else throw new RuntimeException("Non sono presenti elementi!");
		
		
	}
	
	public T winner() {
		
		int max = this.getMaxValue();
		int i = 0;
		for (int elem : this.votiObject) {
			
			if (elem == max)
					return this.objects.elementAt(i);
			i++;
		}
		return null;
	}
	
	public void getVectorVoti() {
		for (int elem : this.votiObject) {
			System.out.println(elem);
		}
	}
	

}
