package lez290425;

import java.util.Iterator;

// Chat = iterabile
public class Chat implements Iterable<Messaggio> {
	
	private final Messaggio[] messaggi;
	private int pos;
	
	public Chat() {
		this.messaggi = new Messaggio[1000];
		this.pos = 0;
	}
	
	public void addMessaggio(Messaggio mess) {
		if (pos < this.messaggi.length)
			messaggi[pos++] = mess;
	}
	
	@Override
	public Iterator<Messaggio> iterator() {
		return new ChatIterator(messaggi);
	}
	
	// MAIN
	public static void main(String[] args) {
		Chat chat = new Chat();
		chat.addMessaggio(new Messaggio("Achille", "Ciao"));
		chat.addMessaggio(new Messaggio("Achille", "yes"));
		chat.addMessaggio(new Messaggio("Achille", "sir"));
		
		Iterator<Messaggio> it = chat.iterator();
		
		while(it.hasNext()) {
			Messaggio m = it.next();
			System.out.println(m);
		}
		
		System.out.println();
		
		// Per ogni messaggio dentro la chat
		// E' possibile fare il foreach perche Chat è Iterable (per definizione nella classe)
		for(Messaggio m : chat) {
			System.out.println(m);
			
		}
	
		
	}


}
