package fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDbDao;
import fr.pizzeria.dao.PizzaJpaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.dao.PizzaTxtDao;

import fr.pizzeria.services.*;

import fr.pizzeria.exception.*;

public class PizzeriaAdminConsoleApp{
	

	private static Scanner option = new Scanner(System.in);
	//private static IPizzaDao pizzaDao = new PizzaDbDao();
	private static PizzaTxtDao pizzaTxtDao = new PizzaTxtDao();
	private static IPizzaDao pizzaJpa = new PizzaJpaDao();
	private static MenuServiceFactory msf = new MenuServiceFactory();
	
	private static  final Logger LOG = LoggerFactory.getLogger(MenuService.class);
	
	public static void main(String[] args) {

		boolean a = true;
		while(a){
			//Affichage du menu
			LOG.info("****** Pizzeria Adminsitration ******");
			LOG.info("1. Lister les pizzas");
			LOG.info("2. Ajouter une nouvelle pizza");
			LOG.info("3. Mettre à jour une pizza");
			LOG.info("4. Supprimer une pizza");
			LOG.info("5. Creer un fichier pdf du menu de pizzas");
			LOG.info("99. Sortir");

			int choix = option.nextInt();
			
			//Permet d'effectuer des actions différentes en fonction du nombres rentré
			try {
				MenuService ms = msf.getInstance(choix);	
				ms.executeUC(pizzaJpa, option);
			} catch (StockageException e) {
				LOG.error(e.getMessage());
			}

			
			//Permet de sortir de l'application
			if (choix == 99)
				a = false;
		}
	}


}
