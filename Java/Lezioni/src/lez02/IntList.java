package lez02;

public class IntList {
	
	private Elem list;
	private int n;
	
	
	public IntList() {
		this.list = null;
		n = 0;
	}
	
	public void addOnHead(int x) {
		Elem newElem = new Elem(x, this.list);
		this.list = newElem;
		n++;
		
	}
	
	public boolean isEmpty() {
		return list == null;
	}
	
	public int removeHead() {
		
		
		if (isEmpty()) {
			throw new RuntimeException("Lista vuota!");
		}
		
		int toRemove = this.list.getData();
		
		this.list = this.list.getNext();
		
		n--;
		
		return toRemove;
		
	}
	
	public void addOnTail(int elem) {
		if(isEmpty()) {
			addOnHead(elem);
			return;
			
			
		}
		
		Elem cursor = this.list;
		
		while(cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		
		// Ultimo nodo da aggiungere
		Elem last = new Elem(elem, null);
		
		cursor.setNext(last);
		
		n++;
		
	}
	
	public int size() {
		return this.n;
	}
	
	public int max() {
		
		if (isEmpty())
			throw new RuntimeException("Lista vuota!");
		
		int max = list.getData();
		Elem cursor = this.list.getNext();
		
		while (cursor != null){
			
			if (max <= cursor.getData())
				max = cursor.getData();
			cursor = cursor.getNext();
		}
		
		return max;
		
	}
	
	public boolean contains(int elem) {
		
		Elem cursor = this.list;
		
		while(cursor != null) {
			if (cursor.getData() == elem)
				return true;
			cursor = cursor.getNext();
		}
		
		return false;
		
	}
	
	public String toString() {
		
		String finalS = "[";
		
		Elem cursor = list;
		
		while (cursor != null) {
			finalS = finalS + cursor.getData();
			if (cursor.getNext() != null) {
				finalS = finalS + ", ";
			}
		}
		
		
		finalS = finalS +"]";
		
		return finalS;
		
	}
	


}
