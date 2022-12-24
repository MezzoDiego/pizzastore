package it.prova.pizzastore.repository.ordine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.prova.pizzastore.model.Ordine;

public class CustomOrdineRepositoryImpl implements CustomOrdineRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Ordine> findyExample(Ordine example) {
		// TODO Auto-generated method stub
		return null;
	}

}
