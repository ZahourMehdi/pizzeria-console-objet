package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.dao.PizzaTxtDao;

public class CreerPizzaPdfService extends MenuService {
	private static PizzaTxtDao pizzaTxtDao = new PizzaTxtDao();
	public void executeUC(PizzaMemDao listPizzaDao, Scanner option){
		System.out.println("Creation du fichier pdf en cours");

		pizzaTxtDao.generatePdf(listPizzaDao);
	}
}
