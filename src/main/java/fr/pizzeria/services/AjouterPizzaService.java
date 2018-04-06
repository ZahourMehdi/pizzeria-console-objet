package fr.pizzeria.services;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import java.util.Scanner;
public class AjouterPizzaService extends MenuService  {


	
	public void executeUC(IPizzaDao listPizzaDao, Scanner option) throws StockageException{
		
		//Ajoute une nouvelle pizza
		LOG.info("Ajout d'une nouvelle pizza");
		LOG.info("Veuillez saisir le code : ");
		String codePizza = option.next();
		LOG.info("Veuillez saisir le nom (sans espace) : ");
		String libellePizza = option.next();
		LOG.info("Veuillez saisir le prix : ");
		String prix = option.next();
		double prixPizza = Double.parseDouble(prix);
		LOG.info("Veuillez saisir la catégorie de la pizza (VIANDE,SANS_VIANDE,POISSON): ");

		String categorie = option.next();
		categorie = categorie.toUpperCase();
		
		if(listPizzaDao.pizzaExists(codePizza))
			throw new PizzaExistException();
		
		if (codePizza.length() > 3)
			throw new LongueurCodeException();
		
		if(prixPizza <= 0)
			throw new PrixNegativeException();
		
		if(!categorie.equalsIgnoreCase("VIANDE") 
			&& !categorie.equalsIgnoreCase("SANS_VIANDE") 
			&& !categorie.equalsIgnoreCase("POISSON") )
			throw new CategorieNameException();
		
		CategoriePizza catPizza =  CategoriePizza.valueOf(categorie);
		Pizza newPizza = new Pizza(codePizza,libellePizza,prixPizza,catPizza);
		listPizzaDao.saveNewPizza(newPizza);
		
		
	}

	
}
