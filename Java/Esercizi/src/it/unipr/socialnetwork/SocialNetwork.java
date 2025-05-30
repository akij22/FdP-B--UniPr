package it.unipr.socialnetwork;
import java.util.*;

public class SocialNetwork implements Iterable<User> {
	
	private String nome;
	
	private Set<User> iscritti;
	
	public SocialNetwork(String nome) {
		this.nome = nome;
		this.iscritti = new HashSet<User>();
	}
	
	
	public void addUser(User other) {
		
		if (this.iscritti.contains(other)) throw new SocialNetworkException();
		
		this.iscritti.add(other);
	}
	
	
	public Iterator<User> iterator() {
		return this.iscritti.iterator();
	}
	
	
	
	

}
