package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;

public class MenuServiceFactory {
	public static MenuService getInstance(int choix){
		switch (choix) {
		case 1:
			return new ListerPizzaService();
			
		case 2:
			return new AjouterPizzaService();
		
		case 3:
			return new ModifierPizzaService();
		
		case 4:
			return new SupprimerPizzaService();
		case 5:
			return new CreerPizzaPdfService();
		case 99:
			return new SortirPizzaService();

		default:
			return null;
		}

	}
}
