package fr.pizzeria.services;


import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import java.util.Scanner;

public class SupprimerPizzaService extends MenuService {
	
	public void executeUC(PizzaMemDao listPizzaDao, Scanner option){
		System.out.println("Suppression d'une pizza");
		System.out.println("Veuillez choisie le code de la pizza à supprimer");
		String codePizzaDel = option.next();
		listPizzaDao.deletePizza(codePizzaDel);
	}

}
