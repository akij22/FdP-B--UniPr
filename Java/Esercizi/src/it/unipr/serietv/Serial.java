package it.unipr.serietv;
// import it.unipr.serietv.Episode;

public class Serial {
	private String titoloSerie;
	private Episode firstEpisode;
	
	
	public Serial() {
		this("", null);
		
	}
	
	
	public Serial(String titolo, Episode firstEpisode) {
		this.titoloSerie = titolo;
		this.firstEpisode = firstEpisode;
	}
	
	
	public String toString() {
		
		String finalS = new String();
		
		Episode cursor = this.firstEpisode;
		
		while(cursor != null) {
			finalS = finalS + cursor.getTitolo() + " " + cursor.getTrama() + "\n";
			cursor = cursor.getNextEpisode();
		}
		
		return finalS;
	}
	
	public String getTitoloSerie() {
		return this.titoloSerie.toLowerCase();
	}
	
	public boolean equals(Serial other) {
		return this.getTitoloSerie().equals(other.getTitoloSerie())
				&& this.firstEpisode.getTitolo().equals(other.firstEpisode.getTitolo());
	}
	
	
}
