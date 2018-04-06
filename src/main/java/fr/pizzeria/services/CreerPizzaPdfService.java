package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.dao.PizzaTxtDao;

public class CreerPizzaPdfService extends MenuService {
	private static PizzaTxtDao pizzaTxtDao = new PizzaTxtDao();
	public void executeUC(IPizzaDao listPizzaDao, Scanner option){
		LOG.info("Creation du fichier pdf en cours");

		pizzaTxtDao.generatePdf(listPizzaDao);
	}
}
