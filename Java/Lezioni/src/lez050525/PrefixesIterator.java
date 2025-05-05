package lez050525;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrefixesIterator implements Iterator<String>{
	private String s;
	

	public PrefixesIterator(String s) {
		this.s = s;
	}
	
	
	@Override
	public boolean hasNext() {
		
		return this.s != null;
	}

	@Override
	public String next() {
		
		if (this.hasNext()) {
			String r = s;
			
			if (r.isEmpty())
				this.s = null;
			else 
				
				// hello
				// hell
				// hel
				// he
				// h
				// null
				this.s = s.substring(0, s.length() - 1);
			return r;
			
		} else throw new NoSuchElementException();
	}

}
