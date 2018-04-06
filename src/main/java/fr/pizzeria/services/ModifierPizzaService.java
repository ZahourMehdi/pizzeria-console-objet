package fr.pizzeria.services;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import java.util.Scanner;
public class ModifierPizzaService extends MenuService {

	
	public void executeUC(IPizzaDao listPizzaDao, Scanner option) throws StockageException{
		LOG.info("Mise à jour d'une pizza");

		LOG.info("Veuillez choisie le code de la pizza à modifier");
		String codePizzaUp = option.next();
		LOG.info("Veuillez saisir nouveau le code : ");
		String nvCodePizza = option.next();
		LOG.info("Veuillez saisir le nouveau nom (sans espace) : ");
		String libellePizzaUp = option.next();
		LOG.info("Veuillez saisir nouveau le prix : ");
		String prix = option.next();
		double prixPizzaUp = Double.parseDouble(prix);
		LOG.info("Veuillez saisir la catégorie de la pizza (VIANDE,SANS_VIANDE,POISSON): ");
		String categorie = option.next();
		categorie = categorie.toUpperCase();
		
		if (nvCodePizza.length() > 3)
			throw new LongueurCodeException();
		
		if(prixPizzaUp <= 0)
			throw new PrixNegativeException();
		
		if(listPizzaDao.pizzaExists(nvCodePizza))
			throw new PizzaExistException();
		
		if(!categorie.equalsIgnoreCase("VIANDE") 
				&& !categorie.equalsIgnoreCase("SANS_VIANDE") 
				&& !categorie.equalsIgnoreCase("POISSON") )
				throw new CategorieNameException();
		
		CategoriePizza catPizza =  CategoriePizza.valueOf(categorie);
		Pizza upPizza = new Pizza(nvCodePizza,libellePizzaUp,prixPizzaUp,catPizza);
		listPizzaDao.updatePizza(codePizzaUp,upPizza);  
		
	}

	
}
