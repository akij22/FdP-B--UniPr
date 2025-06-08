package it.unipr.elezioni02;

public class Test {

	public static void main(String[] args) {
		Partito p1 = new Partito("Partito1");
		Partito p2 = new Partito("Partito1");
		
		System.out.println(p1.equals(p2));

	}

}
