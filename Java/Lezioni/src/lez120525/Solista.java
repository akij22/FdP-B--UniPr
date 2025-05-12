package lez120525;

import java.util.Objects;

public class Solista extends Partecipante {

	public final String strumentoPrincipale;
	
	public Solista(String nome, int anniAttivita, String strumentoPrincipale) {
		super(nome, anniAttivita);
		
		this.strumentoPrincipale = strumentoPrincipale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(strumentoPrincipale);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		
		Solista other = (Solista) obj;
		
		return super.equals(other) && this.strumentoPrincipale.equals(other.strumentoPrincipale);
	}

	@Override
	public String getMotto() {
		return "...solista";
	}


	
	
}
