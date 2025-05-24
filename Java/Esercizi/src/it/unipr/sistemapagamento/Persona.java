package it.unipr.sistemapagamento;

import java.util.*;

public class Persona {

	private String nome;
	private String cognome;
	
	private Vector<MetodoPagamento> pagamenti;
	
	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		
		this.pagamenti = new Vector<MetodoPagamento>();
	}
	
	public void aggiungiPagamento(MetodoPagamento other) {
		this.pagamenti.add(other);
	}
	
	public void paga(MetodoPagamento m, double importo) {
		if (this.pagamenti.contains(m)) {
			for(MetodoPagamento elem : this.pagamenti) {
				if (elem.equals(m)) {
					m.decrementa(importo);
					System.out.println("Pagamento avvenuto con successo!");
				}
			}
		}
		
		return;
	}
	
	
}
