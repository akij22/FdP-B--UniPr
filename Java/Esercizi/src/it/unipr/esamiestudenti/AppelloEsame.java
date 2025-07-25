package it.unipr.esamiestudenti;
import java.util.*;


public class AppelloEsame implements Comparable<AppelloEsame> {

	private String nome;
	private int annoAccademico;
	private Set<Immatricolabile> studenti;
	
	public AppelloEsame(String nome, int annoAccademico) {
	
		this.nome = nome;
		if (annoAccademico < 1930)
			throw new IllegalArgumentException("Anno accademico non valido!");
		
		this.annoAccademico = annoAccademico;
		
		
		this.studenti = new HashSet<Immatricolabile>();
	}
	
	public boolean isEmpty() {
		return this.isEmpty();
	}
	
	
	private int getNumberOfStudentiOrdinari() {
		if (this.isEmpty())
			return 0;
		
		int finalCount = 0;
		
		for (Immatricolabile elem : this.studenti) {
			if (elem instanceof StudenteOrdinario)
				finalCount++;
		}
		
		return finalCount;
	}
	
	private int getNumberOfStudentiLavoratori() {
		if (this.isEmpty())
			return 0;
		
		int finalCount = 0;
		
		for (Immatricolabile elem : this.studenti) {
			if (elem instanceof StudenteLavoratore)
				finalCount++;
		}
		
		return finalCount;
	}
	
	public boolean contains(Immatricolabile other) {
		
		return this.studenti.contains(other);
		
	}
	
	public void iscrivi(Immatricolabile other) throws AppelloEsameException {
		
		if (this.contains(other))
			
			
			throw new AppelloEsameException("Studente gia' iscritto!");
		
		if (other instanceof StudenteOrdinario) {
			if (this.getNumberOfStudentiOrdinari() == 50)
				
				throw new AppelloEsameException("E' stato raggiunto il massimo numero di student ordinari per questo esame!");
			else this.studenti.add(other);
		
		} else if (other instanceof StudenteLavoratore) {
			
			if (this.getNumberOfStudentiLavoratori() == 50)

				throw new AppelloEsameException("E' stato raggiunto il massimo numero di student lavoratori per questo esame!");
			
			else this.studenti.add(other);
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		AppelloEsame other = (AppelloEsame) o;
		
		return this.nome.equals(other.nome) && this.annoAccademico == other.annoAccademico && this.studenti.equals(other.studenti);
	}
	
	
	public int compareTo(AppelloEsame other) {
		return Integer.compare(this.getNumberOfStudentiLavoratori(), other.getNumberOfStudentiLavoratori());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.nome, this.annoAccademico, this.studenti);
	}
	
	
	
}
