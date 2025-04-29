package task5;
import java.util.Scanner;

public class Task5 {
	
	

	public static void main(String[] args) {
		
		
		String s1 = null, s2 = null;
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("Inserisci prima stringa: ");
			
			s1 = sc.nextLine();
			
			if (s1.equals("$"))
				break;
			
			
			System.out.println("Inserisci seconda stringa: ");
			s2 = sc.nextLine();
			
			int countCheck = 0;
			int checkPalindrome = 0;
			
			if (s1.length() == s2.length()) {
				
				
				
				for (int i = 0; i < s1.length(); i++) {
					countCheck = 0;
					
					for(int j = 0; j < s2.length(); j++) {
						
						if (s1.charAt(i) == s2.charAt(j) && countCheck == 0) {
							countCheck++;
							checkPalindrome++;
						}
					}
				}
				// System.out.println(checkPalindrome);
				
				if (checkPalindrome == s1.length())
					System.out.println("Le parole sono palindrome!");
				else if (checkPalindrome == 0)
					System.out.println("Le due parole non hanno lettere in comune!");
			}
			
			
			
		} while (true);
		
		System.out.println("Addio...");
		
		sc.close();
		

	}

}
