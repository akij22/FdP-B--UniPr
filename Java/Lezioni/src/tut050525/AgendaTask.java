package tut050525;

import java.util.NoSuchElementException;

public class AgendaTask<T extends Task & Comparable<T>> {
	
	private T[] tasks;
	private int numeroTask;
	
	private static final int CAPACITY = 100;
	
	public AgendaTask() {
		
		// Cast: stiamo dando un array di Task, ma lui si 
		// aspetta un array di tipo T
		this.tasks = (T[]) new Task[CAPACITY];
	}
	
	public void addTask(T other) {
		
		if (other == null ) throw new IllegalArgumentException();
		if (this.numeroTask >= CAPACITY)
			throw new RuntimeException("Capacita' massima raggiunta");
		
		
		
		// Devo garantire che l'array di task sia sempre ordinato per priorità
		
		int insertionPointer = 0;
		
		
		while(insertionPointer < this.numeroTask 
				&& other.compareTo(this.tasks[insertionPointer]) > 0) {
			
			insertionPointer++;
		}
		
		
		// shift degli elementi
		
		for (int i = this.numeroTask; i > insertionPointer; i--) {
			this.tasks[i] = this.tasks[i - 1];
		}
		
		this.tasks[insertionPointer] = other;
		this.numeroTask++;
	}
	
	
	public boolean isEmpty() {
		return this.numeroTask == 0;
	}
	
	
	
	// Returna la task con la priorità più alta
	
	/**
	 * @return: the first element in T array, keeping it in the array
	 */
	public T getNextTask() {
		if (this.isEmpty())
			throw new NoSuchElementException();
		
		return this.tasks[0];
		
	}
	
	
	// Completa la task con la priorità più alta
	// Completa = rimuove
	
	/**
	 * @return: the first element in T array and remove it from the array
	 */
	public T tickNextTask() {
		
		if (this.isEmpty())
			throw new NoSuchElementException();
		
		T result = this.tasks[0];
		
		for (int i = 0; i< this.numeroTask; i++) {
			this.tasks[i] = this.tasks[i + 1];
		}
		
		
		return result;
	}
	
	
	public int getNumTasks() {
		return this.numeroTask;
	}
	
	
	

}
