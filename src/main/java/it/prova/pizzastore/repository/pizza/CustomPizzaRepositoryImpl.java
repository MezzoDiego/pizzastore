package it.prova.pizzastore.repository.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.prova.pizzastore.model.Pizza;

public class CustomPizzaRepositoryImpl implements CustomPizzaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Pizza> findByExample(Pizza example) {
		// TODO Auto-generated method stub
		return null;
	}

}
