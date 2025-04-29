package lez02;
import java.util.Scanner;




public class Fibonacci {
	
	
	// Versione ricorsiva
	public static int calcolaFibonacciRic(int n) {
		
		if(n == 0) return 0;
		
		else if (n == 1) return 1;
		
		
		return calcolaFibonacciRic(n - 1) + calcolaFibonacciRic(n - 2);
		
	}
	
	
	// Versione interativa
	public static int calcolaFibonacciIt(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		
		int sumFinal = 0;
		
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		for (int i = 1; i < n; i++) {
			
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			
		}
		return n3;
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int fibo = 0;
		
		System.out.print("Inserisci numero intero: ");
		
		fibo = sc.nextInt();
		
		int finalFiboRec = calcolaFibonacciRic(fibo);
		
		System.out.println(finalFiboRec);
		
		int finalFiboIt = calcolaFibonacciIt(fibo);
		
		System.out.println(finalFiboIt);
		
	}
	
}
