package it.prova.pizzastore.web.api;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.pizzastore.dto.ClienteDTO;
import it.prova.pizzastore.dto.OrdineDTO;
import it.prova.pizzastore.dto.StatisticheOrdiniDTO;
import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.service.OrdineService;
import it.prova.pizzastore.web.api.exceptions.IdNotNullForInsertException;
import it.prova.pizzastore.web.api.exceptions.NotFoundException;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {

	@Autowired
	private OrdineService ordineService;

	@GetMapping
	public List<OrdineDTO> getAll() {
		return OrdineDTO.createOrdineDTOListFromModelList(ordineService.listAllOrdini());
	}

	@PostMapping
	public OrdineDTO createNew(@Valid @RequestBody OrdineDTO ordineInput) {
		// se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
		// non sta bene
		if (ordineInput.getId() != null)
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

		Ordine ordineInserito = ordineService.inserisciNuovo(ordineInput.buildOrdineModel());
		return OrdineDTO.buildOrdineDTOFromModel(ordineInserito);
	}

	@GetMapping("/{id}")
	public OrdineDTO findById(@PathVariable(value = "id", required = true) long id) {
		Ordine ordine = ordineService.caricaSingoloOrdine(id);

		if (ordine == null)
			throw new NotFoundException("Ordine not found con id: " + id);

		return OrdineDTO.buildOrdineDTOFromModel(ordine);
	}

	@GetMapping("changeAbilitation/{id}")
	public void changeAbilitation(@PathVariable(value = "id", required = true) long id) {
		ordineService.changeAbilitation(id);
	}

	@PutMapping("/{id}")
	public OrdineDTO update(@Valid @RequestBody OrdineDTO ordineInput, @PathVariable(required = true) Long id) {
		Ordine ordine = ordineService.caricaSingoloOrdine(id);

		if (ordine == null)
			throw new NotFoundException("Ordine not found con id: " + id);

		ordineInput.setId(id);
		Ordine ordineAggiornato = ordineService.aggiorna(ordineInput.buildOrdineModel());
		return OrdineDTO.buildOrdineDTOFromModel(ordineAggiornato);
	}

	@PostMapping("/search")
	public List<OrdineDTO> search(@RequestBody OrdineDTO example) {
		return OrdineDTO.createOrdineDTOListFromModelList(ordineService.findByExample(example.buildOrdineModel()));
	}

	@PostMapping("/ricaviTotaliBetween")
	public Integer ricaviTotaliBetween(@Valid @RequestBody StatisticheOrdiniDTO dateInput) {
		return ordineService.ricaviTotaliBetween(dateInput.getDataInizio(), dateInput.getDataFine());
	}

	@PostMapping("/ordiniTotaliBetween")
	public Integer ordiniTotaliBetween(@Valid @RequestBody StatisticheOrdiniDTO dateInput) {
		return ordineService.ordiniTotaliBetween(dateInput.getDataInizio(), dateInput.getDataFine());
	}

	@PostMapping("/pizzeTotaliOrderedBetween")
	public Integer pizzeTotaliOrderedBetween(@Valid @RequestBody StatisticheOrdiniDTO dateInput) {
		return ordineService.pizzeOrdinateBetween(dateInput.getDataInizio(), dateInput.getDataFine());
	}

	@PostMapping("/clientiVirtuosiWithOrdineBetween")
	public List<ClienteDTO> clientiVirtuosiWithOrdineBetween(@Valid @RequestBody StatisticheOrdiniDTO dateInput) {
		return ClienteDTO.createClienteDTOListFromModelList(
				ordineService.clientiVirtuosiBetween(dateInput.getDataInizio(), dateInput.getDataFine()));
	}

	@GetMapping("/fattorino")
	public List<OrdineDTO> ordiniPerFattorino(Principal principal) {
		return OrdineDTO.createOrdineDTOListFromModelList(ordineService.ordiniPerFattorino(principal.getName()));
	}
}
