package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.repository.pizza.PizzaRepository;

@Service
@Transactional(readOnly = true)
public class PizzaServiceImpl implements PizzaService{

	@Autowired
	private PizzaRepository repository;

	@Override
	public List<Pizza> listAllPizze() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza caricaSingolaPizza(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Pizza aggiorna(Pizza pizzaInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Pizza inserisciNuova(Pizza pizzaInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void rimuovi(Long idToRemove) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pizza> findByExample(Pizza example) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
