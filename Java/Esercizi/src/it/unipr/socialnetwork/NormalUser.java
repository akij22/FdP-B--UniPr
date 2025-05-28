package it.unipr.socialnetwork;
import java.util.*;


public class NormalUser implements User {

	private String nome;
	private String cognome;
	private Vector<User> amici;
	
	public NormalUser(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		
		this.amici = new Vector<User>();
	}
	
	
	public void addFriend(User friend) {
		
		if (friend == this) throw new SocialNetworkException();
		
		this.amici.add(friend);
	}
	
	
	public int getNumberOfFriends() {
		return this.amici.size();
	}
	
	public String getUsername() {
		
		return this.nome + " " + this.cognome + " " + this.getNumberOfFriends();
		
	}
	
	
	@Override
	public String toString() {
		return this.getUsername();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		NormalUser other = (NormalUser) o;
		
		return this.nome.equals(other.nome) && this.cognome.equals(other.cognome);
	}
	
	
	public void follow(PremiumUser other) {
		if (other.getListOfFollowers().contains(this)) throw new SocialNetworkException();
		
		other.addFollower(this);
	}
}
