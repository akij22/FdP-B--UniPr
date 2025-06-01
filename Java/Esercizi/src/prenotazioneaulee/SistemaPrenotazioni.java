package prenotazioneaulee;
import java.util.*;

public class SistemaPrenotazioni implements Iterable<Prenotazione> {

	private Vector<Prenotazione> prenotazioni;
	
	
	public SistemaPrenotazioni() {
		this.prenotazioni = new Vector<Prenotazione>();
	}
	
	
	public void aggiungiPrenotazione(Prenotazione other) {
		if (this.prenotazioni.contains(other))

			// TODO
			throw new RuntimeException("Prenotazione gia' presente!!!");
		
		this.prenotazioni.add(other);
	}
	
	
	public Set<Prenotazione> getAuleStandardPrenotateOn(String data){
		
		Set<Prenotazione> finalS = new HashSet<Prenotazione>();
		
		if (this.prenotazioni.isEmpty()) return finalS;
		
		for(Prenotazione elem : this.prenotazioni) {
			
			if (elem.getAula() instanceof AulaStandard && elem.getData().equals(data)) {
				finalS.add(elem);
			}
			
		}
		
		return finalS;
	}
	
	public Iterator<Prenotazione> iterator(){
		return this.prenotazioni.iterator();
	}
}
