package it.prova.pizzastore.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.pizzastore.service.PizzaService;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;

}
