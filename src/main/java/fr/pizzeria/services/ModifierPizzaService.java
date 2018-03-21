package fr.pizzeria.services;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import java.util.Scanner;
public class ModifierPizzaService extends MenuService {

	
	public void executeUC(PizzaMemDao listPizzaDao, Scanner option){
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Veuillez choisie le code de la pizza à modifier");
		String codePizzaUp = option.next();
		System.out.println("Veuillez saisir nouveau le code : ");
		String nvCodePizza = option.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
		String libellePizzaUp = option.next();
		System.out.println("Veuillez saisir nouveau le prix : ");
		double prixPizzaUp = option.nextDouble();
		Pizza upPizza = new Pizza(nvCodePizza,libellePizzaUp,prixPizzaUp);
		listPizzaDao.updatePizza(codePizzaUp,upPizza);  
		
	};
	
}
