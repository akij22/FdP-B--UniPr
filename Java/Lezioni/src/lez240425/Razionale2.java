package lez240425;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class Razionale2 {

	private int n;
	private int d;

	public Razionale2() {
		n = 0;
		d = 1;
	}

	public Razionale2(Razionale other) {
		n = other.getNum();
		d = other.getDen();
	}

	public Razionale2(int num, int den) {
		n = num;
		if (den == 0) 
			throw new DenominatoreUgualeAZeroException();
		else
			d = den;
	}

	/**
	 * Legge un razionale da uno scanner {@code sc} passato come parametro nel formato n/d, dove n e d devono
	 * corrispondere a interi.
	 * 
	 * @param sc lo scanner da cui leggere il razionale
	 * @throws CarattereSeparatoreException se il carattere separatore non corrisponde a '/' (slash)
	 * @throws DenominatoreUgualeAZeroException se il denominatore inserito dall'utente è zero
	 */
	
	public void leggi(Scanner sc) throws CarattereSeparatoreException, DenominatoreUgualeAZeroException {
		int num, den;
		String frazione = sc.nextLine();

		int sepIdx = frazione.indexOf('/');

		if (sepIdx == -1)
			throw new CarattereSeparatoreException();

		num = Integer.parseInt(frazione.substring(0, sepIdx));
		den = Integer.parseInt(frazione.substring(sepIdx + 1));

		n = num;
		if (den == 0)
			throw new DenominatoreUgualeAZeroException();
		else
			d = den;
	}

	public Razionale somma(Razionale other) {
		Razionale result = new Razionale();
		result.setNum(this.n * other.getDen() + this.d * other.getNum());
		result.setDen(this.d * other.getDen());
		// result.d = this.d * other.d;
		// result.n = this.n * other.d + d * other.n;
		return result;
	}

	public int getNum() {
		return n;
	}

	public void setNum(int n) {
		this.n = n;
	}

	public int getDen() {
		return d;
	}

	public void setDen(int d) {
		if (d == 0)
			throw new DenominatoreUgualeAZeroException();
		this.d = d;
	}

	@Override
	public String toString() {
		return n + "/" + d;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if (obj == null)
			return false;
		else if (this.getClass() != obj.getClass())
			return false;

		Razionale other = (Razionale) obj;
		return this.d == other.getDen() && this.n == other.getNum();
	}

	// Override di clone, definito in Object
	@Override
	public Razionale clone() {
		return new Razionale(this.n, this.d);
		
	}

	
	
	
	public static void main(String[] args) {
		char c1, c2, c3;

		try {
			c1 = (char) System.in.read();
			c2 = (char) System.in.read();
			c3 = (char) System.in.read();
		} catch (IOException e) {
			System.err.println("Something bad happened");
			return;
		}

		System.out.println(c1 + " " + c2 + " " + c3);
	}
}
