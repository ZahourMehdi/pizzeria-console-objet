package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao{

	private static List <Pizza> listPizza = new ArrayList();
	
	public PizzaMemDao(){
		listPizza.add(new Pizza(0,"PEP","Pépéroni",12.50));
		listPizza.add(new Pizza(1,"MAR","Margherita",14.00));
		listPizza.add(new Pizza(2,"REIN","La Reine",11.50));
		listPizza.add(new Pizza(3,"FRO","La 4 fromages",12.00));
		listPizza.add(new Pizza(4,"CAN","La cannibale",12.50));
		listPizza.add(new Pizza(5,"SAV","La savoyarde",13.00));
		listPizza.add(new Pizza(6,"ORI","L'orientale",13.50));
		listPizza.add(new Pizza(7,"IND","L'indienne",14.00));
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
			return listPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		listPizza.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		Pizza upPizza = findPizzaByCode(codePizza);
		upPizza.setCode(pizza.getCode());
		upPizza.setLibelle(pizza.getLibelle());
		upPizza.setPrix(pizza.getPrix());	
	}

	@Override
	public void deletePizza(String codePizza) {
		Pizza delPizza = findPizzaByCode(codePizza);
		
		for (int i = 0; i < listPizza.size(); i++) {
			if(listPizza.get(i).equals(delPizza)){
				listPizza.remove(i);
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (int i = 0; i < listPizza.size(); i++) {
			if(listPizza.get(i).getCode().equals(codePizza)){
				return listPizza.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for (int i = 0; i < listPizza.size(); i++) {
			if (listPizza.get(i).getCode().equals(codePizza)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
