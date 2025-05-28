package it.unipr.socialnetwork;
import java.util.*;


public class PremiumUser implements User, Comparable<PremiumUser> {

	private String username;
	private Vector<User> follow;
	
	
	public PremiumUser(String username) {
		this.username = username;
		
		this.follow = new Vector<User>();
	}
	
	public void addFollower(User other) {
		if (this.follow.contains(other)) throw new SocialNetworkException();
		
		this.follow.add(other);
	}
	
	
	public Vector<User> getListOfFollowers(){
		return new Vector<User>(this.follow);
	}
	
	
	public String getUsername() {
		return this.username;
	}
	
	
	@Override
	public String toString() {
		return this.getUsername();
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		PremiumUser other = (PremiumUser) o;
		
		return this.username.equals(other.username);
	}
	
	
	public int compareTo(PremiumUser other) {
		if (this.follow.size() < other.follow.size()) return -1;
		
		if (this.follow.size() > other.follow.size()) return 1;
		
		return 0;
	}
}
