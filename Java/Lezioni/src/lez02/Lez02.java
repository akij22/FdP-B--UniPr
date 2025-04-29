package lez02;
import java.util.Scanner;


public class Lez02 {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Inserisci dimensione triangolo rettangolo: ");
		int n = sc.nextInt() + 1;
		
		
		if (n <= 0)
			return;
		
		
		char[][] matrix = new char[n][n];
		

		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (j < i)
					matrix[i][j] = '*';
				else
					matrix[i][j] = ' ';
			}
		}
		
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
		
		
		sc.close();
		
		
		
		}

	}


