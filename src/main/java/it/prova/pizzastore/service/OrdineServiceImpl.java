package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.repository.ordine.OrdineRepository;

@Service
@Transactional(readOnly = true)
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineRepository repository;

	@Override
	public List<Ordine> listAllOrdini() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordine caricaSingoloOrdine(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Ordine aggiorna(Ordine ordineInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Ordine inserisciNuovo(Ordine ordineInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void rimuovi(Long idToRemove) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ordine> findByExample(Ordine example) {
		// TODO Auto-generated method stub
		return null;
	}

}
