package task4;
import java.util.Scanner;
public class Task4 {

	public static void main(String[] args) {
		/* 

			Scrivere un programma in C++
 			che legge n numeri interi da tastiera 
 			e il memorizza in un array. Il programma deve stampare, 
 			per ogni cifra contenuta nell'array, il numero delle occorrenze.

*/
		Scanner sc = new Scanner(System.in);
		
		
		int dimension = 0;
	
		int[] a;
		
		
		System.out.print("Inserisci dimensione dell'array: ");
		dimension = sc.nextInt();
		
		a = new int[dimension];
		
		for (int i = 0; i < dimension; i ++) {
			System.out.print("Inserisci numero: ");
			a[i] = sc.nextInt();
		}
		
		int countOccurrence = 0;
		
		
		int[] finalArray = getFinalArray(a, dimension);
		
		for (int elem : a) {
			
			
			countOccurrence = 0;
			
			System.out.print("Occorrenza dell'elemento " + elem + ": ");
			for (int i = 0; i < a.length; i++) {
				
				if (a[i] == elem) {
					
					countOccurrence++;
				}
			}
			
			System.out.println(countOccurrence);
		}
		
		sc.close();
		
		

	}
	
	public static int[] getFinalArray(int[] a, int dimension) {
		
		int[] finalArray = new int[dimension];
		boolean check = true;
		int index = 0;
		
		for(int i = 0; i < dimension; i++) {
			
			check = true;
			
			for (int j = 0; j < dimension; j++) {
				
				if (a[i] == a[j])
					check = false;
			}
			if (check) {
				finalArray[index] = a[i];
				index++;
			}
		}
		
		
		return finalArray;
		
	}

}
