package fr.pizzeria.services;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;
import java.util.Scanner;
public class ModifierPizzaService extends MenuService {

	
	public void executeUC(PizzaMemDao listPizzaDao, Scanner option) throws StockageException{
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Veuillez choisie le code de la pizza à modifier");
		String codePizzaUp = option.next();
		System.out.println("Veuillez saisir nouveau le code : ");
		String nvCodePizza = option.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
		String libellePizzaUp = option.next();
		System.out.println("Veuillez saisir nouveau le prix : ");
		String prix = option.next();
		double prixPizzaUp = Double.parseDouble(prix);
		
		if (nvCodePizza.length() > 3)
			throw new LongueurCodeException();
		
		if(prixPizzaUp <= 0)
			throw new PrixNegativeException();
		
		if(listPizzaDao.pizzaExists(nvCodePizza))
			throw new PizzaExistException();
		
		Pizza upPizza = new Pizza(nvCodePizza,libellePizzaUp,prixPizzaUp);
		listPizzaDao.updatePizza(codePizzaUp,upPizza);  
		
	};
	
}
