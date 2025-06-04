package it.unipr.stack;
import java.util.*;

public class Stack<T> implements Comparable<Stack<T>> {
	
	private List<T> elements;
	
	
	public Stack() {
		this.elements = new ArrayList<T>();
	}
	
	
	public void push(T elem) {
		
		this.elements.add(elem);
		
	}
	
	public void pop() {
		
		if (this.elements.isEmpty())
			throw new RuntimeException();
		
		T toRemove = null;
		
		for (T elem : this.elements)
			toRemove = elem;
		
		this.elements.remove(toRemove);
	}
	
	
	public T peek() {
			
		if (this.elements.isEmpty())
			throw new RuntimeException();
		
		T toReturn = null;
		
		for (T elem : this.elements)
			toReturn = elem;
		
		return toReturn;
	}
	
	public int size() {
		return this.size();
	}
	
	
	@Override
	public String toString() {
		
		String finalS = null;
		
		if (this.elements.isEmpty())
				finalS = "Stack vuoto...";
		
		
		
		else finalS = "[ ";
		
		int check = 0;
		
		for (T elem : this.elements) {
			
			if (check == this.elements.size() - 1)
				finalS = finalS + elem + " ";
			else
				finalS = finalS + elem + ", ";
			
			check++;
				
		}
		
		
		finalS += "]";
		
		return finalS;
	}
	
	public boolean isEmpty() {
		return this.elements.isEmpty();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Stack<T> other = (Stack<T>) o;
		
		return this.elements.equals(other.elements);
	}
	
	
	
	public int compareTo(Stack<T> other) {
		return Integer.compare(this.elements.size(), other.elements.size());
	}
	
	
	
	
	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		
		s1.push(10);
		s1.push(12);
		s1.push(12);
		s1.push(12);
		s1.push(99);
		
		s1.pop();
		
		
		System.out.println(s1);
		
	}

	
	
	


}
