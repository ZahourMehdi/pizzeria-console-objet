package fr.pizzeria.services;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import java.util.Scanner;
public class AjouterPizzaService extends MenuService {


	
	public void executeUC(PizzaMemDao listPizzaDao, Scanner option){
		//Affiche la liste des pizzas
		
		System.out.println("Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code : ");
		String codePizza = option.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String libellePizza = option.next();
		System.out.println("Veuillez saisir le prix : ");
		double prixPizza = option.nextDouble();
		Pizza newPizza = new Pizza(codePizza,libellePizza,prixPizza);
		listPizzaDao.saveNewPizza(newPizza);
	};
	
}
