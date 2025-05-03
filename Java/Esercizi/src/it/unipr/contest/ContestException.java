package it.unipr.contest;

public class ContestException extends Exception{
	
	
	public ContestException() {
		super("The specified object does not partecipate in the contest."
				+ "	To insert it use the add method, provided by Contest class");
	}

}
