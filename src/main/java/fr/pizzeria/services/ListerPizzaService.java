package fr.pizzeria.services;
 
import java.util.Scanner;

import  fr.pizzeria.dao.*;

public class ListerPizzaService extends MenuService {

	public void executeUC(PizzaMemDao listPizzaDao, Scanner option){
		//Affiche la liste des pizzas
		System.out.println("Liste des pizzas");
		for (int i = 0; i < listPizzaDao.findAllPizzas().size(); i++) {
			System.out.println(listPizzaDao.findAllPizzas().get(i).toString());
		}
	}
	
}
