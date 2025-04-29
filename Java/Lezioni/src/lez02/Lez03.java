package lez02;
import java.util.Scanner;
public class Lez03 {

	public static void main(String[] args) {

		
		
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[100];
		
		String s = new String("ciao");
		
		int len = 0;
		int n = 0;
		
		do {
			
			System.out.println("Inserisci numero: ");
			n = sc.nextInt();
			if (n < 0)
				break;
			
			a[len] = n;
			len++;
		} while (len < 100);
		
		
		int max = a[0];
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		
		System.out.println("Il massimo e' " + max);
		sc.close();
	}
	
	
	
	

}
