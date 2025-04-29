package lez02;
import java.util.Scanner;
/*
 * Scrivere un programma che legge una stringa da standard input e stamparla su
 * standard output con l’iniziale maiuscola*/


public class LezStringhe {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = new String();
		
		System.out.print("Inserisci stringa: ");
		
		str = sc.nextLine();
		
		char upper = str.charAt(0);
		
		upper = Character.toUpperCase(upper);
		
		// System.out.println(upper);
		
		
		// Creo una nuova stringa, in quanto non posso modificarla in-place
		// Per definizione, le stringhe sono immutabili
		String finalStr = new String();
		
		finalStr = upper + str.substring(1);
		
		
		System.out.println("Stringa finale: " + finalStr);
		
		
		sc.close();
		

	}

}
