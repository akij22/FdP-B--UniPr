package it.unipr.analizzatoretesto;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnalizzatoreTesto {

	// Conto numero di occorrenze di ciascuna parola
	
	// String --> key, Integer --> value
	private Map<String, Integer> frequenze;
	
	
	
	
	public AnalizzatoreTesto() {
		this.frequenze = new HashMap<String, Integer>();
	}
	
	
	
	void aggiungiTesto(String testo) {
		
		if (testo == null || testo.isEmpty())
			return;
		
		String tempParola = "";
		
		for (int i = 0; i < testo.length(); i++) {

			
			char tempChar = testo.charAt(i);
			
			if (Character.isWhitespace(tempChar)) {
				
				// Per ogni parola della frase, richiamo aggiungiParola
				this.aggiungiParola(tempParola);
				
				tempParola = "";
				
				
			// Per contare ultima parola (dato che non termina con spazio vuoto)
			} else if (i == testo.length() -1) {
				
				tempParola += tempChar;
				this.aggiungiParola(tempParola);
			} else 
				tempParola += tempChar;
		}
	}
	
	
	
	
	int frequenzaParola(String key) {
		
		Integer finalValue = this.frequenze.get(key);
		
		
		return finalValue != null ? finalValue : 0;
		
		
		
	}

	// Aggiungo una singola parola
	void aggiungiParola(String parola) {
		
		this.frequenze.put(parola, this.frequenze.getOrDefault(parola, 0) + 1);
	}
	
	
	
	public Set<String> paroleFrequenti(int soglia){
		
		HashSet<String> finalResult = new HashSet<>();
		
		
		for (Entry<String, Integer> entry : this.frequenze.entrySet()) {
			
			if (entry.getValue() >= soglia)
				
				finalResult.add(entry.getKey());
		}
		
		return finalResult;
		
		
		
	}
	
	String parolaPiuFrequente() {
		if (this.frequenze.isEmpty()) {
			return "";
		}
		
		
		int max = 0;
		
		String finalResult = "";
		
		for (Entry<String, Integer> entrySet : this.frequenze.entrySet()) {
			
			
			if (entrySet.getValue() > max) {
				max = entrySet.getValue();
				finalResult = entrySet.getKey();
			}
		}
		
		
		return finalResult;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		AnalizzatoreTesto a1 = new AnalizzatoreTesto();
		
		a1.aggiungiTesto("Cane e Cane Cane");
		
		
		System.out.println(a1.frequenzaParola("Cane"));
		System.out.println(a1.frequenzaParola("Gatto"));
		
		
		System.out.println(a1.parolaPiuFrequente());
		
		
		
		
		
	}
	 
	
}
