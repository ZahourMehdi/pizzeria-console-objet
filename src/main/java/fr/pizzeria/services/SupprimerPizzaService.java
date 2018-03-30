package fr.pizzeria.services;


import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.LongueurCodeException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;
import java.util.Scanner;

public class SupprimerPizzaService extends MenuService {
	
	public void executeUC(PizzaMemDao listPizzaDao, Scanner option) throws StockageException{
		LOG.info("Suppression d'une pizza");
		LOG.info("Veuillez choisie le code de la pizza à supprimer");
		String codePizzaDel = option.next();
		
		if (codePizzaDel.length() > 3)
			throw new LongueurCodeException();
		
		if (!listPizzaDao.pizzaExists(codePizzaDel))
			throw new DeletePizzaException("La pizza que vous voulez supprimer n'existe pas \n");
			
		listPizzaDao.deletePizza(codePizzaDel);
	}

}
