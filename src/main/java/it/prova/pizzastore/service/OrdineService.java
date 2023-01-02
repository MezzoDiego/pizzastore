package it.prova.pizzastore.service;

import java.time.LocalDate;
import java.util.List;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Ordine;

public interface OrdineService {

	public List<Ordine> listAllOrdini();

	public Ordine caricaSingoloOrdine(Long id);
	
	public Ordine caricaSingoloOrdineConPizze(Long id);

	public Ordine aggiorna(Ordine ordineInstance);

	public Ordine inserisciNuovo(Ordine ordineInstance);

	public void rimuovi(Long idToRemove);

	public List<Ordine> findByExample(Ordine example);
	
	public Integer calcolaPrezzoOrdine(Long idOrdine);
	
	public void changeAbilitation(Long id);
	
	public Integer ricaviTotaliBetween(LocalDate dataInizio, LocalDate dataFine);
	
	public Integer ordiniTotaliBetween(LocalDate dataInizio, LocalDate dataFine);
	
	public Integer pizzeOrdinateBetween(LocalDate dataInizio, LocalDate dataFine);
	
	public List<Cliente> clientiVirtuosiBetween(LocalDate dataInizio, LocalDate dataFine);
	
	public List<Ordine> ordiniPerFattorino(String username);
	
}
