package it.prova.pizzastore.repository.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.prova.pizzastore.model.Cliente;

public class CustomClienteRepositoryImpl implements CustomClienteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Cliente> findByExample(Cliente example) {
		// TODO Auto-generated method stub
		return null;
	}

}
