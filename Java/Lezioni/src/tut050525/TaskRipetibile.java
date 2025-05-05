package tut050525;

import java.util.Objects;

public class TaskRipetibile extends TaskSemplice{

	private int intervalloGiorni;
	
	
	public TaskRipetibile(int priorita, String descrizione, String dataScadenza, int intervalloGiorni) {
		
		super(priorita, descrizione, dataScadenza);
		this.intervalloGiorni = intervalloGiorni;
		
	}


	@Override
	public int hashCode() {
		return super.hashCode() + this.intervalloGiorni;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (!super.equals(obj))
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		TaskRipetibile other = (TaskRipetibile) obj;
		return super.equals(other) && intervalloGiorni == other.intervalloGiorni;
	}
	
	
	
	

}
