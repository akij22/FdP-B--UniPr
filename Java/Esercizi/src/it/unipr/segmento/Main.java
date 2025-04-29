package it.unipr.segmento;

public class Main {

	public static void main(String[] args) {
		Pointer p1 =  new Pointer(5, 10);
		Pointer p2 =  new Pointer(9, 15);
		
		Segment s1 = new Segment(p1, p2);
		
		System.out.println(s1.getMidpoint());
		
		System.out.println(s1.toString());

		
		Segment clone = s1.clone(s1);
		
		System.out.println(clone);
	}

}
