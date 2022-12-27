package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Ordine;

public interface OrdineService {

	public List<Ordine> listAllOrdini();

	public Ordine caricaSingoloOrdine(Long id);

	public Ordine aggiorna(Ordine ordineInstance);

	public Ordine inserisciNuovo(Ordine ordineInstance);

	public void rimuovi(Long idToRemove);

	public List<Ordine> findByExample(Ordine example);
	
	public Integer calcolaPrezzoOrdine(Long idOrdine);
	
	public void changeAbilitation(Long id);
	
}
