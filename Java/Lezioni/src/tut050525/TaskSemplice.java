package tut050525;

public class TaskSemplice implements Task, Comparable<TaskSemplice>{

	
	private int priorita;
	private String descrizione;
	private String dataScadenza;
	
	
	
	public TaskSemplice(int priorita, String descrizione, String dataScadenza)
	{
		this.priorita = priorita;
		this.descrizione = descrizione;
		this.dataScadenza = dataScadenza;
	}
	
	
	@Override
	public int compareTo(TaskSemplice other) {
		
		if (this.priorita != other.priorita)
			if (this.priorita < other.priorita) return -1;
		
			else if (this.priorita > other.priorita) return -1;
		
		
		// Splitta la stringa, returnando un array di stringe con tutti gli split
		// Lo split avvien in corrispondenza del carattere specificato
		String[] thisData = this.dataScadenza.split("/");
		String[] otherData = other.dataScadenza.split("/");
		
		if (thisData.length != 3 || otherData.length != 3)
			throw new IllegalArgumentException();
		
		
		try {
			int thisYear = Integer.parseInt(thisData[0]);
			int otherYear = Integer.parseInt(otherData[0]);
			
			if (thisYear != otherYear) {
				if (thisYear > otherYear) return 1;
				else if (thisYear < otherYear) return -1;
			}
			
			int thisMonth = Integer.parseInt(thisData[1]);
			int otherMonth = Integer.parseInt(otherData[1]);
			
			if (thisMonth != otherMonth) {
				if (thisMonth > otherMonth) return 1;
				else if (thisMonth < otherMonth) return -1;
			}
			
			
			int thisDay = Integer.parseInt(thisData[2]);
			int otherDay = Integer.parseInt(otherData[2]);
			
			if (thisDay != otherDay) {
				if (thisDay > otherDay) return 1;
				else if (thisDay < otherDay) return -1;
			}
		
		}catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		
		return 0;
		
	}
	
	
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || this.getClass() != o.getClass()) return false;
		
		
		TaskSemplice other = (TaskSemplice) o;
		
		return this.priorita == other.priorita && this.descrizione.equals(other.descrizione) && this.dataScadenza.equals(other.dataScadenza);
	}
	
	
	
	// Generazione di un numero univoco per ogni istanza dell'oggetto
	@Override
	public int hashCode() {
		
		return this.priorita + this.descrizione.hashCode() * 17 + dataScadenza.hashCode() + 19;
	}

	@Override
	public int getPriorita() {
		return this.priorita;
	}

	@Override
	public String getDescrizione() {
		return this.descrizione;
	}

	@Override
	public String getDataScadenza() {
		return this.dataScadenza;
	}

}
