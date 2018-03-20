  package fr.pizzeria.console;

import java.util.Arrays;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

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
			Scanner option = new Scanner(System.in);
			int choix = option.nextInt();
			//Permet d'effectuer des actions différentes en fonction du nombres rentré
			switch (choix) {
			case 1:
				System.out.println("Liste des pizzas");
				break;
			case 2:
				System.out.println("Ajout d'une nouvelle pizza");
				break;
			case 3:
				System.out.println("Mise à jour d'une pizza");
				break;
			case 4:
				System.out.println("Suppression d'une pizza");
				break;
			case 99:
				System.out.println("Au revoir !");
				a = false;
				break;
			default:
				System.out.println("Erreur, entrer un des nombres proposés");
				break;
			}
		}
	}


}
