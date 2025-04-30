package it.unipr.ordinatore;

public class OrdinatoreMain {

	public static void main(String[] args) {
		
		int a = 54;
		int b = 28;
		int c = 91;
		
		Ordinatore<Integer> o1 = new Ordinatore(a);
		
		System.out.println("Confronto elemento " + o1.getPrevElem() + " con " + b);
		System.out.println(o1.check(b));
		
		System.out.println("Confronto elemento " + o1.getPrevElem() + " con " + c);
		System.out.println(o1.check(c));
		
		System.out.println("Confronto elemento " + o1.getPrevElem() + " con " + c);
		System.out.println(o1.check(c));

	}

}
