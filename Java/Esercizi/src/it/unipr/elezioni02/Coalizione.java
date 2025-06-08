package it.unipr.elezioni02;
import java.util.HashSet;
import java.util.Set;


public class Coalizione extends Eleggibile {

	
	private Set<Partito> partiti;
	
	
	
	public Coalizione(String nome, Partito[] partiti) {
		super(nome);
		
		this.partiti = new HashSet<Partito>();
		
		for (int i = 0; i < partiti.length; i++) {
			if (!this.partiti.contains(partiti[i]))
				this.partiti.add(partiti[i]);
		}
		
		int nVotiSum = 0;
		
		for (Partito p : this.partiti) {
			nVoti += p.getNVoti();
		}
		
		this.nVoti = nVotiSum;
		
	}
	
	@Override
	public int getNVoti() {
		if (this.partiti.isEmpty()) return 0;
		
		int finalSum = 0;
		
		for (Partito p : this.partiti)
			finalSum += p.getNVoti();
		
		return finalSum;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		Coalizione other = (Coalizione) o;
		
		return this.nome.equals(other.nome) && this.partiti.equals(other.partiti);
	}
}

