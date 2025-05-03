package it.unipr.contest;

public class MainContest {

	public static void main(String[] args) throws ContestException {
		Contest<String> c = new Contest();
		
		String r = "Red", b = "Blue", g = "Green";
		
		
		c.add(r);
		c.add(b);
		c.add(g);
		
		c.vote(r);
		c.vote(r);
		c.vote(b);
		c.vote(g);
		c.vote(g);
		c.vote(g);
		
		
		
		System.out.println(c.winner()); // stampa Green

	}

}
