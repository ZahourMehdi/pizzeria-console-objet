package fr.pizzeria.dao;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.NullCodeException;
import fr.pizzeria.model.Pizza;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPizzaDao.
 * @author Zahour Mehdi
 */
public interface IPizzaDao {
	
	/**
	 * Find all pizzas.
	 *
	 * @return the list
	 */
	List<Pizza> findAllPizzas();
	
	/**
	 * Save new pizza.
	 *
	 * @param pizza the pizza
	 */
	void saveNewPizza(Pizza pizza) ;
	
	/**
	 * Update pizza.
	 *
	 * @param codePizza the code pizza
	 * @param pizza the pizza
	 * @throws NullCodeException the null code exception
	 */
	void updatePizza(String codePizza, Pizza pizza) throws NullCodeException;
	
	/**
	 * Delete pizza.
	 *
	 * @param codePizza the code pizza
	 */
	void deletePizza(String codePizza) ;
	
	/**
	 * Find pizza by code.
	 *
	 * @param codePizza the code pizza
	 * @return the pizza
	 */
	Pizza findPizzaByCode(String codePizza) ;
	
	/**
	 * Pizza exists.
	 *
	 * @param codePizza the code pizza
	 * @return true, if successful
	 */
	boolean pizzaExists(String codePizza);
}
