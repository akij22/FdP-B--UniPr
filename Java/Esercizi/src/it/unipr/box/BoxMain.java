package it.unipr.box;

public class BoxMain {

	public static void main(String[] args) {
		Box<Integer> b1 = new Box();
		
		Box<String> b2 = new Box();
		
		
		b1.add(5);
		b1.add(4);
		b1.add(9);
		
		if(b1.isPresent(4))
			System.out.println("Elemento 4 presente");
		else
			System.out.println("Elemento 4 non presente");
		
		
		System.out.println(b1.greatest());
		System.out.println("Size: " + b1.getSize());
		b1.remove(4);
		
		if(b1.isPresent(4))
			System.out.println("Elemento 4 presente");
		else
			System.out.println("Elemento 4 non presente");
		
		
		

	}

}
