package fr.pizzeria.console;


import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

import fr.pizzeria.dao.PizzaMemDao;

import fr.pizzeria.services.*;

public class PizzeriaAdminConsoleApp{
	

	private static Scanner option = new Scanner(System.in);
	private static PizzaMemDao pizzaDao = new PizzaMemDao();
	private static MenuServiceFactory msf = new MenuServiceFactory();
	
	//private static ListerPizzaService listePizzaService = new ListerPizzaService();
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
			System.out.println("99. Sortir");

			int choix = option.nextInt();
			
			//Permet d'effectuer des actions différentes en fonction du nombres rentré
			MenuService ms = msf.getInstance(choix);	
			ms.executeUC(pizzaDao, option);
			
			//Permet de soritr de l'application
			if (choix == 99)
				a = false;
			
			
			/*switch (choix) {
			case 1:
				//Affiche la liste des pizzas
				//listePizzaService.executeUC(pizzaDao, option);
				msf.getInstance(choix);
				
				
				break;
				
			//Ajout d'une nouvelle pizza
			case 2:
				ajoutPizzaService.executeUC(pizzaDao,option);
				break;
				
			//Modifie une pizza
			case 3:	
				modifiePizzaService.executeUC(pizzaDao, option);
				break;
			
			//Supprime un pizza
			case 4:
				supprimePizzaService.executeUC(pizzaDao, option);
				break;
			case 99:
				System.out.println("Au revoir !");
				a = false;
				break;
			default:
				System.out.println("Erreur, entrer un des nombres proposés");
				break;
			}*/
		}
	}


}
