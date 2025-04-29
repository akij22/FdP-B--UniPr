package lez240425;

import java.io.InputStream;
import java.util.Scanner;

public class Razionale implements Cloneable {
	
	private int num;
	private int den;
	
	
	public Razionale() {
		// DELEGA DEL COSTRUTTORE, deve essere la prima riga
		this(0, 1);
	}
	
	public Razionale(int num, int den) {
		if (den == 0) {
			throw new RuntimeException("Denominatore uguale a zero!");
			
		}
		
		this.num = num;
		this.den = den;
	}
	
	public Razionale somma(Razionale other) {
		
		// Non posso modificarlo al di fuori del costruttore, quindi utilizzo il costruttore
		Razionale result = new Razionale(num * other.den + den * other.num, den * other.den);
		
		return result;
	}
	
	
	// Ridefinisco il metodo toString per poter stampare un razionle con sysout
	public String toString() {
		return new String(this.num + " / " + this.den);
	}
	
	
	// NON E' IL VERO METODO EQUALS FORNITO A TUTTE LE CLASSI --> non sarebbe da utilizzare
	public boolean equals(Razionale other) {
		return this.num == other.num && this.den == other.den;
	}
	
	
	// Questo è il vero metodo equals messo a disposizione da Java ad ogni classe
	public boolean equals(Object other) {
		return false;	
	}
	
	
	public void read(Scanner in) {
		int num, den;
			
		System.out.println("Inserisci Raionale: ");
		String line = in.nextLine();
		
		int sep = line.indexOf("/");
		
		// Carattere separatore non presente --> lancio una eccezione generica
		if (sep == -1)
			throw new RuntimeException("Carattere separatore non valido");
		
		num = Integer.parseInt(line.substring(0, sep));
		
		den = Integer.parseInt(line.substring(sep + 1));
		
		if (den == 0) {
			throw new RuntimeException("Denominatore uguale a zero!");	
			
		}
		
		this.num = num;
		this.den = den;
	
	}
	
	
	@Override
	public Razionale clone() throws CloneNotSupportedException {
		// return new Razionale(this.num, this.den);
		return (Razionale) super.clone();
	}
	
	
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDen() {
		return den;
	}

	public void setDen(int den) {
		
		if (den == 0)
			throw new RuntimeException("Denominatore ugulae a 0!");
		
		this.den = den;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		Razionale r1 = new Razionale(1, 2);
		
		Razionale r2 = new Razionale(1, 2);
		
		Razionale r3;
		r3 = new Razionale();
		Razionale r4 = new Razionale();
		
		r3.read(sc);
		r4.read(sc);
		
		System.out.println(r1);
		System.out.println(r2);
		
		System.out.println(r1.somma(r2));
		
		System.out.println(r3);
		System.out.println(r4);

	}

}
