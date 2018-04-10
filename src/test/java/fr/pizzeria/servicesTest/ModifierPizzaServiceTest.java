package fr.pizzeria.servicesTest;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.*;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.*;
import fr.pizzeria.services.ModifierPizzaService;
public class ModifierPizzaServiceTest {

	
	/** Création d'une "Rule" qui va permettre
	* de substituer le System.in utilisé par le Scanner
	* par un mock: systemInMock */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	/**
	 * Test de modifier pizza service a l'aide d'un mock
	 * @throws StockageException
	 */
	@Test
	public void testExecuteUC() throws StockageException {
		ModifierPizzaService mps = new ModifierPizzaService();
		
		systemInMock.provideLines("PEP","PIZ","PIZZZA","15.0","VIANDE");

		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
	
		Mockito.when(mockedDao.findPizzaByCode(Mockito.anyString())).thenReturn(null);
	

		
		Scanner sc = new Scanner(System.in);
		mps.executeUC(mockedDao, sc);
	}

}
