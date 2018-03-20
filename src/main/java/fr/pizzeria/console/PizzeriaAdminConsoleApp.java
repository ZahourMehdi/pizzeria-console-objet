package fr.pizzeria.console;


import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang.ArrayUtils;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	private static Pizza[] arrayPizza;
	private static int idPizza;
	private static Scanner option = new Scanner(System.in);
	private static void ajoutCarte(){
		System.out.println("Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code : ");
		String codePizza = option.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String libellePizza = option.next();
		System.out.println("Veuillez saisir le prix : ");
		double prixPizza = option.nextDouble();
		
		for (int i = 0; i < arrayPizza.length; i++) {
			if (arrayPizza[i] == null){
				arrayPizza[i] = new Pizza (codePizza, libellePizza, prixPizza);
				break;
			}
		}
	}
	private static void afficheCarte(){
		System.out.println("Liste des pizzas");
		for (int i = 0; i < arrayPizza.length; i++) {
			if(arrayPizza[i] == null){
				break;
			}else{
				System.out.println(arrayPizza[i]);
			}
		}
	}
	
	private static void modifierCarte(){
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Veuillez choisie le code de la pizza à modifier");
		String codePizza = option.next();

		for (int i = 0; i < arrayPizza.length; i++) {
			if (arrayPizza[i] == null){
				break;
			}
			if (arrayPizza[i].getCode().equals(codePizza)){
				idPizza = arrayPizza[i].getId();
			}
		}

		System.out.println("Veuillez saisir nouveau le code : ");
		codePizza = option.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
		String libellePizza = option.next();
		System.out.println("Veuillez saisir nouveau le prix : ");
		double prixPizza = option.nextDouble();
		
		for (int i = 0; i < arrayPizza.length; i++) {
			if (arrayPizza[i].getId() == idPizza ){
				arrayPizza[i].setCode(codePizza);
				arrayPizza[i].setLibelle(libellePizza);
				arrayPizza[i].setPrix(prixPizza);
				break;
			}
		}
	}
	
	private static void deletePizza(){
		System.out.println("Suppression d'une pizza");
		System.out.println("Veuillez choisie le code de la pizza à supprimer");
		String codePizza = option.next();
		for (int i = 0; i < arrayPizza.length; i++) {
			if (arrayPizza[i] == null){
				break;
			}
			if (arrayPizza[i].getCode().equals(codePizza)){
				arrayPizza = (Pizza[]) ArrayUtils.remove(arrayPizza,i);
			}
		}
	}
	public static void main(String[] args) {
			

		arrayPizza = new Pizza[1000];
		arrayPizza[0] = new Pizza(0,"PEP","Pépéroni",12.50);
		arrayPizza[1] = new Pizza(1,"MAR","Margherita",14.00);
		arrayPizza[2] = new Pizza(2,"REIN","La Reine",11.50);
		arrayPizza[3] = new Pizza(3,"FRO","La 4 fromages",12.00);
		arrayPizza[4] = new Pizza(4,"CAN","La cannibale",12.50);
		arrayPizza[5] = new Pizza(5,"SAV","La savoyarde",13.00);
		arrayPizza[6] = new Pizza(6,"ORI","L'orientale",13.50);
		arrayPizza[7] = new Pizza(7,"IND","L'indienne",14.00);
		
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
			switch (choix) {
			case 1:
				afficheCarte();
				break;
			case 2:
				ajoutCarte();
				break;
			case 3:
				modifierCarte();
				
				break;
			case 4:
				deletePizza();
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
