package lez050525;

import java.util.Iterator;
import java.util.Objects;

public class Prefixes implements Iterable<String>{
	
	private final String frase;
	
	public Prefixes(String frase) {
		
		Objects.requireNonNull(frase);
		this.frase = frase;
	}

	@Override
	public Iterator<String> iterator() {
		
		return new PrefixesIterator(this.frase);
	}
	
	
	public static void main(String[] args) {
		Prefixes p1 = new Prefixes("hello");
		
		Iterator<String> it = p1.iterator();
		
		while (it.hasNext()) {
			String finalS = it.next();
			System.out.println(finalS);
		}
	}
	
	
	
	

}
