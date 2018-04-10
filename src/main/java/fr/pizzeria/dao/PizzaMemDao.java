package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.NullCodeException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

// TODO: Auto-generated Javadoc
/**
 * The Class PizzaMemDao.
 * @author Zahour Mehdi
 */
public class PizzaMemDao implements IPizzaDao{

	/** The list pizza. */
	private static List <Pizza> listPizza = new ArrayList();
	
	/**
	 * Instantiates a new pizza mem dao.
	 */
	public PizzaMemDao(){
		listPizza.add(new Pizza(0,"PEP","Pépéroni",12.50, CategoriePizza.VIANDE));
		listPizza.add(new Pizza(1,"MAR","Margherita",14.00, CategoriePizza.SANS_VIANDE));
		listPizza.add(new Pizza(2,"REI","La Reine",11.50, CategoriePizza.VIANDE));
		listPizza.add(new Pizza(3,"FRO","La 4 fromages",12.00, CategoriePizza.SANS_VIANDE));
		listPizza.add(new Pizza(4,"CAN","La cannibale",12.50, CategoriePizza.VIANDE));
		listPizza.add(new Pizza(5,"SAV","La savoyarde",13.00, CategoriePizza.VIANDE));
		listPizza.add(new Pizza(6,"ORI","L'orientale",13.50, CategoriePizza.VIANDE));
		listPizza.add(new Pizza(7,"IND","L'indienne",14.00, CategoriePizza.POISSON));
		
	}
	
	/* 
	 * retourne la liste des pizza enregister
	 */
	@Override
	public List<Pizza> findAllPizzas() {
			return listPizza;
	}

	/* 
	 * Permet d'enregistrer une nouvelle pizza
	 */
	@Override
	public void saveNewPizza(Pizza pizza) {
		listPizza.add(pizza);
	}

	/* 
	 * Permet de modifier une pizza des existante
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws NullCodeException {
		Pizza upPizza = findPizzaByCode(codePizza);
		if (upPizza== null){
			throw new NullCodeException();
		}
		upPizza.setCode(pizza.getCode());
		upPizza.setLibelle(pizza.getLibelle());
		upPizza.setPrix(pizza.getPrix());
		upPizza.setCategoriePizza(pizza.getCategoriePizza());
	}

	/* 
	 * Permet de supprimer un pizza
	 */
	@Override
	public void deletePizza(String codePizza) {
		Pizza delPizza = findPizzaByCode(codePizza);
		
		for (int i = 0; i < listPizza.size(); i++) {
			if(listPizza.get(i).equals(delPizza)){
				listPizza.remove(i);
			}
		}
	}

	/* 
	 * Permet de chercher une pizza grace a son code
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (int i = 0; i < listPizza.size(); i++) {
			if(listPizza.get(i).getCode().equals(codePizza)){
				return listPizza.get(i);
			}
		}
		return null;
	}

	/*
	 * Verifie si une pizza existe
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		for (int i = 0; i < listPizza.size();i++) {
			if (listPizza.get(i).getCode().equals(codePizza)) {
				return true;
			}
		}
		return false;
	}

}
