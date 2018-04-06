package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.NullCodeException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	List<Pizza> findAllPizzas();
	void saveNewPizza(Pizza pizza) ;
	void updatePizza(String codePizza, Pizza pizza) throws NullCodeException;
	void deletePizza(String codePizza) ;
	Pizza findPizzaByCode(String codePizza) ;
	boolean pizzaExists(String codePizza);
}
