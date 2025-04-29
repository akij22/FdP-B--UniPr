package lez290425;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChatIterator implements Iterator<Messaggio>{

	private final Messaggio[] messaggi;
	private int cursor;
	
	
	// cursor tiene traccia degli elementi iterati
	public ChatIterator(Messaggio [] messaggi) {
		this.messaggi = messaggi;
		
		this.cursor = 0;
	}
	
	
	@Override
	public boolean hasNext() {
		return cursor < this.messaggi.length && messaggi[cursor] != null;
	}

	@Override
	public Messaggio next() {
		
		// Controllo aggiuntivo
		if (this.hasNext()) {
			
			// Ritorno il messaggio in posizione indicata da cursor
			// e vado avanti nei messaggi
			return this.messaggi[cursor++];
			
		} else throw new NoSuchElementException();		
	}
	
	
}
