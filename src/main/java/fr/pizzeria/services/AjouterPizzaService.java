package fr.pizzeria.services;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;
import java.util.Scanner;
public class AjouterPizzaService extends MenuService  {


	
	public void executeUC(PizzaMemDao listPizzaDao, Scanner option) throws StockageException{
		//Affiche la liste des pizzas
		
		System.out.println("Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code : ");
		String codePizza = option.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String libellePizza = option.next();
		System.out.println("Veuillez saisir le prix : ");
		String prix = option.next();
		double prixPizza = Double.parseDouble(prix);
		Pizza newPizza = new Pizza(codePizza,libellePizza,prixPizza);
		

		
		if(listPizzaDao.pizzaExists(codePizza))
			throw new PizzaExistException();
		
		if (codePizza.length() > 3)
			throw new LongueurCodeException();
		
		if(prixPizza <= 0)
			throw new PrixNegativeException();
		

		listPizzaDao.saveNewPizza(newPizza);
	};
	
}
