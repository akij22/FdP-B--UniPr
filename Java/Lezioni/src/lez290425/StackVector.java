package lez290425;

import java.util.Vector;

public class StackVector<T> implements Stack<T> {
	
	

	private final Vector<T> elements;
	private int top;

	
	public StackVector() {
		this.elements = new Vector<T>();
		this.top = 0;
	}

	@Override
	public void push(T other) {
		this.elements.add(other);
		this.top++;
		
	}

	@Override
	public T pop() {
		if (!isEmpty()) {
			top--;
			return elements.remove(top);
		} else
			throw new RuntimeException("Stack vuoto!");
		
	}

	@Override
	public boolean isEmpty() {
		return this.top == 0;
	}
	
	
	

}
