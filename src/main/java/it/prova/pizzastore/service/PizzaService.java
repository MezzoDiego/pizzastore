package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Pizza;

public interface PizzaService {

	public List<Pizza> listAllPizze();

	public Pizza caricaSingolaPizza(Long id);

	public Pizza aggiorna(Pizza pizzaInstance);

	public Pizza inserisciNuova(Pizza pizzaInstance);

	public void rimuovi(Long idToRemove);

	public List<Pizza> findByExample(Pizza example);
	
	public void changeAbilitation(Long id);
	
}
