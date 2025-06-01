package prenotazioneaulee;

import java.util.Objects;

public class AulaStandard extends Aula {

	private int nLavagne;
	
	
	public AulaStandard(String nome, int capienzaMax, int nLavagne) {
		
		super(nome, capienzaMax);
		
		if (nLavagne <= 0)
			throw new RuntimeException();
		
		this.nLavagne = nLavagne;
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(nLavagne);
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		
		AulaStandard other = (AulaStandard) o;
		
		return super.equals(o) && other.nLavagne == this.nLavagne;
	}
		
	
	
	
}
