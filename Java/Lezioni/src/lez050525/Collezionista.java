package lez050525;

import java.util.Objects;

public class Collezionista {

	private final String nome;
	private final String cognome;
	private final Album album;
	
	public Collezionista(String nome, String cognome, Album album) {
		this.nome = nome;
		this.cognome = cognome;
		this.album = album;
	}

	@Override
	public int hashCode() {
		return Objects.hash(album, cognome, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collezionista other = (Collezionista) obj;
		
		return Objects.equals(album, other.album) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(nome, other.nome);
	}
	
	
	// Lancio eccezione controllata, quindi la devo specificare nella signature
	public void scambia(Collezionista other, Figurina figthis, Figurina figother) throws CollezionistaException {
		
		if(!this.album.contains(figthis) || !other.album.contains(figother)) {
			throw new CollezionistaException("Figurina non appartenente al rispettivo proprietario!");
		}
		
		
		// Parte di scambio delle due figurine tra i due collezionisti
		this.album.remove(figthis);
		other.album.remove(figother);
		
		this.album.add(figother);
		other.album.add(figthis);
		
		
	}
	
	
	
}
