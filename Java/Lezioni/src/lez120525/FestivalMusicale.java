package lez120525;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FestivalMusicale implements Iterable<Esibizione>{

	private final List<Esibizione> esibizioni;
	
	public FestivalMusicale() {
		
		this.esibizioni = new ArrayList<Esibizione>();
	}
	
	public void AggiungiEsibizione(Esibizione other) throws EsibizioneEsistenteException{
		
		// this.esibizioni.contains(other);
		
		// Implementazione "from scratch"
		for (Esibizione e : this.esibizioni) {
			
			// Nel caso esista gia una esibizione uguale al parametro, lancio custom exception
			if (e.getPartecipante().equals(other))
				throw new EsibizioneEsistenteException();
		}
		
		this.esibizioni.add(other);
	}
	
	
	public Set<Partecipante> getPartecipantiByDataEOra(String dataEOra){
		
		Set<Partecipante> finalSet = new HashSet<Partecipante>();
		
		for (Esibizione e : this.esibizioni) {
			
			if (e.getDataEOra().equals(dataEOra)) {
				finalSet.add(e.getPartecipante());
			}
		}
		
		return finalSet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(esibizioni);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		FestivalMusicale other = (FestivalMusicale) obj;
		
		// Confronta elementi e il loro ordine dei due ArrayList
		return Objects.equals(esibizioni, other.esibizioni);
	}
	
	

	@Override
	public Iterator<Esibizione> iterator() {
		return this.esibizioni.iterator();
	}
	
	
}
