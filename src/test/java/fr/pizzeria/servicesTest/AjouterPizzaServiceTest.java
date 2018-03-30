package fr.pizzeria.servicesTest;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.CategorieNameException;
import fr.pizzeria.exception.LongueurCodeException;
import fr.pizzeria.exception.PizzaExistException;
import fr.pizzeria.exception.PrixNegativeException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.services.AjouterPizzaService;

import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

public class AjouterPizzaServiceTest {
	
	/** Création d'une "Rule" qui va permettre
	* de substituer le System.in utilisé par le Scanner
	* par un mock: systemInMock */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	
	/**
	 * Test de l'exception sur l'ajout de la pizza (Longueur pizza exception)
	 */
	@Test(expected=LongueurCodeException.class)
	public void testExecuteUC_exceptionPizzaLongueur() throws StockageException {
		
			AjouterPizzaService aps = new AjouterPizzaService();
			systemInMock.provideLines("PIZZ","PIZZZA","15.0","CategoriePizza.VIANDE");
			PizzaMemDao dao = new PizzaMemDao();
			Scanner sc = new Scanner(System.in);
			aps.executeUC(dao, sc);

		}
	/**
	 * Test de l'exception sur l'ajout de la pizza( Pizza existe exception )
	 */
	@Test(expected=PizzaExistException.class)
	public void testExecuteUC_exceptionPizzaExist() throws StockageException {
		
			AjouterPizzaService aps = new AjouterPizzaService();
			systemInMock.provideLines("PEP","PIZZZA","15.0","VIANDE");
			PizzaMemDao dao = new PizzaMemDao();
			Scanner sc = new Scanner(System.in);
			aps.executeUC(dao, sc);

		}
	
	/**
	 * Test de l'exception sur l'ajout d'une nouvelle pizza ( Prix négative exception )
	 */
	@Test(expected=PrixNegativeException.class)
	public void testExecuteUC_exceptionPrixNegative() throws StockageException{
		
		AjouterPizzaService aps = new AjouterPizzaService();
		systemInMock.provideLines("PIZ","PIZZZA","-2.0","VIANDE");
		PizzaMemDao dao = new PizzaMemDao();
		Scanner sc = new Scanner(System.in);
		aps.executeUC(dao, sc);	
	}
	
	/**
	 * Test de l'exception sur l'ajout d'une nouvelle pizza ( Categorie Name exception )
	 */
	@Test(expected=CategorieNameException.class)
	public void testExecuteUC_exceptionCategorieName() throws StockageException{
		AjouterPizzaService aps = new AjouterPizzaService();
		systemInMock.provideLines("PIZ","PIZZZA","15.0","faux");
		PizzaMemDao dao = new PizzaMemDao();
		Scanner sc = new Scanner(System.in);
		aps.executeUC(dao, sc);	
		
	}
	/**
	 * Test de l'ajout d'une nouvelle pizza valide
	 */
	@Test
	public void testExecuteUC_PizzaValid() throws StockageException{
		AjouterPizzaService aps = new AjouterPizzaService();
		systemInMock.provideLines("PIZ","PIZZZA","15.0","VIANDE");
		PizzaMemDao dao = new PizzaMemDao();
		int lengthBefore = dao.findAllPizzas().size();
		
		Scanner sc = new Scanner(System.in);
		aps.executeUC(dao, sc);	
		
		int lengthAfter = dao.findAllPizzas().size();
		
		assertTrue("La longueur de la list de pizza est différente",(lengthBefore+1)==lengthAfter);
	}
	
	/**
	 * Test de l'ajout d'une nouvelle pizza null
	 */
	@Test(expected=StockageException.class)
	public void testExecuteUC_PizzaNull() throws StockageException{
		AjouterPizzaService aps = new AjouterPizzaService();
		systemInMock.provideLines(null,null,"0.0",null);
		PizzaMemDao dao = new PizzaMemDao();		
		Scanner sc = new Scanner(System.in);
		aps.executeUC(dao, sc);	
	}
}


