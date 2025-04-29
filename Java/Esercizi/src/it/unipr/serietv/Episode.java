package it.unipr.serietv;

public class Episode {
	private String titolo;
	private String trama;
	private Episode nextEpisode;
	
	
	public Episode() {
		this("", "", null);
	}
	
	public Episode(String titolo, String trama, Episode nextEpisode) {
		this.titolo = titolo;
		this.trama = trama;
		this.nextEpisode = nextEpisode;
	}
	
	public String toString() {
		return "titolo" + this.titolo + ", trama: " + this.trama + ", titolo prossimo episodio: " + this.nextEpisode.titolo;
	}
	
	public boolean equals(Episode other) {
		return this.titolo.equals(other.titolo.toLowerCase()) && this.nextEpisode.titolo.equals(other.nextEpisode.titolo.toLowerCase());
	}
	
	String getTitolo() {
		return this.titolo.toLowerCase();
	}
	
	public String getTrama() {
		return this.trama.toLowerCase();
	}
	
	public Episode getNextEpisode() {
		return this.nextEpisode;
	}
	
	public void setNextEpisode(Episode next) {
		this.nextEpisode = next;
	}
	
	

}
