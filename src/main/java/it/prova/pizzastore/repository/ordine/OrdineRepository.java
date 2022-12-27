package it.prova.pizzastore.repository.ordine;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine, Long>, CustomOrdineRepository {
	@Query(value= "select sum(p.prezzoBase) from Pizza p join ordine_pizza op on p.id=op.pizza_id where ordine_id = ?1", nativeQuery = true)
	Integer calcolaSommaPrezzi(Long id);
	
	@Query("select sum(o.costoTotale) from Ordine o where o.data between ?1 and ?2")
	Integer calcolaRicaviTotaliTra(LocalDate dataInizio, LocalDate dataFine);
	
	Integer countByDataBetween(LocalDate dataInizio, LocalDate dataFine);
	
	@Query(value = "select count(op.pizza_id) from ordine_pizza op join ordine o on o.id = op.ordine_id where o.data between ?1 and ?2", nativeQuery = true)
	Integer countPizzeOrderedBetween(LocalDate dataInizio, LocalDate dataFine);
	
	@Query("select distinct c from Ordine o join o.cliente c where c is not null and o.costoTotale > 100 and o.data between ?1 and ?2")
	List<Cliente> findAllClientiVirtuosiBetween(LocalDate dataInizio, LocalDate dataFine);

}
