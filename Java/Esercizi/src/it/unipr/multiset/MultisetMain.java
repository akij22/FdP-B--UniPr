package it.unipr.multiset;

import java.util.Iterator;

public class MultisetMain {

	public static void main(String[] args) {
		Multiset<Integer> m1 = new Multiset();
		Multiset<Integer> m2 = new Multiset();
		
		m1.add(15);
		m1.add(19);
		m1.add(19);
		
		m2.add(19);
		m2.add(15);
		m2.add(19);
		m2.add(21);
		
		System.out.println(m1.equals(m2));
		
		
		// Creo un Iterator dello stesso tipo del data type del mio Multiset
		Iterator<Integer> it = m1.iterator();
		
		while(it.hasNext()) {
			int content = it.next();
			System.out.println(content);
		}
	}

}
