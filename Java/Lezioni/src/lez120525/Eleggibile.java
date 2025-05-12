package lez120525;

public interface Eleggibile {
	
	public String getNome();
	
	public int getVoti();
	
	
	// Costringo l'override del metodo equals a tutte le classi
	// che implementano tale interfaccia
	public boolean equals(Object obj);

}
