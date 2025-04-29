package it.unipr.mystring;

public class MyString {
	private char[] str;
	private int len;
	
	public MyString() {
		this.len = 0;
	}
	
	
	public MyString(char[] str) {
		this.str = new char[str.length];
		
		for (int i = 0; i < str.length; i++) {
			this.str[i] = str[i];
			this.len++;
		}
	}
	
	
	char[] getStr() {
		return this.str;
	}
	
	void setStr(char[] str) {
		
		if (str.length == 0) {
			throw new RuntimeException("Stringa vuota!");
		}
		for (int i = 0; i < str.length; i++) {
			this.str[i] = str[i];
		}
	}
	
		
	boolean anagrammi(char[] other) {
		
		int finalCounter = 0;
		
		boolean tempCheck = false;
		
		if (this.str.length == other.length) {
			
			for(int i = 0; i < this.str.length; i++) {
				
				tempCheck = false;
				
				for(int j = 0; j < other.length; j++) {
					
					if (this.str[i] == other[j] && !tempCheck) {
						finalCounter++;
						tempCheck = true;
					}
					
					
				}
			}
			
			if (finalCounter == this.str.length)
				return true;
			else 
				return false;
		} else 
			return false;
		
	}
	
	
	boolean equals(MyString other) {
		if (this.anagrammi(other.str))
			return true;
		else return false;
		
		
	}
	
	public String toString() {
		String finalS = "";
		
		for (int i = 0; i < this.len; i++) {
			finalS = finalS + this.str[i];
		}
		
		return finalS;
	}
	
	
}
