package it.prova.pizzastore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.repository.ordine.OrdineRepository;
import it.prova.pizzastore.web.api.exceptions.NotFoundException;

@Service
@Transactional(readOnly = true)
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineRepository repository;

	@Override
	public List<Ordine> listAllOrdini() {
		return (List<Ordine>) repository.findAll();
	}

	@Override
	public Ordine caricaSingoloOrdine(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Ordine aggiorna(Ordine ordineInstance) {
		Ordine ordineReloaded = repository.findById(ordineInstance.getId()).orElse(null);
		if (ordineReloaded == null)
			throw new NotFoundException("Elemento non trovato");

		ordineReloaded.setCodice(ordineInstance.getCodice());
		ordineReloaded.setData(ordineInstance.getData());
		ordineReloaded.setCliente(ordineInstance.getCliente());
		ordineReloaded.setFattorino(ordineInstance.getFattorino());
		ordineReloaded.setPizze(ordineInstance.getPizze());
		repository.save(ordineReloaded);
		ordineReloaded.setCostoTotale(calcolaPrezzoOrdine(ordineInstance.getId()));
		return repository.save(ordineReloaded);
	}

	@Override
	@Transactional
	public Ordine inserisciNuovo(Ordine ordineInstance) {
		ordineInstance.setClosed(false);
		System.out.println(calcolaPrezzoOrdine(ordineInstance.getId()));
		repository.save(ordineInstance);
		ordineInstance.setCostoTotale(calcolaPrezzoOrdine(ordineInstance.getId()));
		return repository.save(ordineInstance);
	}

	@Override
	@Transactional
	public void rimuovi(Long idToRemove) {
		repository.deleteById(idToRemove);

	}

	@Override
	public List<Ordine> findByExample(Ordine example) {
		return repository.findyExample(example);
	}

	@Override
	public Integer calcolaPrezzoOrdine(Long idOrdine) {
		return repository.calcolaSommaPrezzi(idOrdine);
	}

	@Override
	@Transactional
	public void changeAbilitation(Long id) {
		Ordine ordineInstance = caricaSingoloOrdine(id);
		if (ordineInstance == null)
			throw new NotFoundException("Elemento non trovato.");

		if (ordineInstance.getClosed()) {
			ordineInstance.setClosed(false);
		} else {
			ordineInstance.setClosed(true);
		}

	}

	@Override
	public Integer ricaviTotaliBetween(LocalDate dataInizio, LocalDate dataFine) {
		return repository.calcolaRicaviTotaliTra(dataInizio, dataFine);
	}

	@Override
	public Integer ordiniTotaliBetween(LocalDate dataInizio, LocalDate dataFine) {
		return repository.countByDataBetween(dataInizio, dataFine);
	}

	@Override
	public Integer pizzeOrdinateBetween(LocalDate dataInizio, LocalDate dataFine) {
		return repository.countPizzeOrderedBetween(dataInizio, dataFine);
	}

	@Override
	public List<Cliente> clientiVirtuosiBetween(LocalDate dataInizio, LocalDate dataFine) {
		return repository.findAllClientiVirtuosiBetween(dataInizio, dataFine);
	}

}
