package prenotazioneaulee;

public abstract class Aula {
	
	private String nome;
	private int capienzaMax;
	
	
	
	public Aula(String nome, int capienzaMax) {
		this.nome = nome;
		
		if (capienzaMax <= 0)
			throw new RuntimeException();
		
		this.capienzaMax = capienzaMax;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		
		Aula other = (Aula) o;
		
		return this.nome.equals(other.nome) && this.capienzaMax == other.capienzaMax;
	}

}
