package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.dao.PizzaTxtDao;

import fr.pizzeria.services.*;

import fr.pizzeria.exception.*;

public class PizzeriaAdminConsoleApp{
	

	private static Scanner option = new Scanner(System.in);
	private static PizzaMemDao pizzaDao = new PizzaMemDao();
 
	private static MenuServiceFactory msf = new MenuServiceFactory();
	
	private static ListerPizzaService listePizzaService = new ListerPizzaService();
	private static AjouterPizzaService ajoutPizzaService = new AjouterPizzaService();
	private static ModifierPizzaService modifiePizzaService = new ModifierPizzaService();
	private static SupprimerPizzaService supprimePizzaService = new SupprimerPizzaService();
	
	public static void main(String[] args) {

		boolean a = true;
		while(a){
			//Affichage du menu
			System.out.println("****** Pizzeria Adminsitration ******");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("5. Creer un fichier pdf du menu de pizzas");
			System.out.println("99. Sortir");

			int choix = option.nextInt();
			
			//Permet d'effectuer des actions différentes en fonction du nombres rentré
			try {
				MenuService ms = msf.getInstance(choix);	
				ms.executeUC(pizzaDao, option);
			} catch (StockageException e) {
				System.out.println(e.getMessage());
			}

			
			//Permet de sortir de l'application
			if (choix == 99)
				a = false;
		}
	}


}
