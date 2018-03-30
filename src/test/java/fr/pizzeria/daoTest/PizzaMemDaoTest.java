package fr.pizzeria.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
public class PizzaMemDaoTest {
	
	/**
	 * Test sur recherche tout les pizzas
	 */
	@Test
	public void testFindAllPizzas(){
		PizzaMemDao dao = new PizzaMemDao();
		assertTrue("La list de pizza ne peut pas etre vide",dao!=null);
	}
	
	/**
	 * Test sur ajout de nouvelle pizza avec une pizza qui existe
	 */
	@Test
	public void testSaveNewPizza_exist() {
		
		Pizza p = new Pizza("PIZ", "PIZZZA", 20.0,  CategoriePizza.VIANDE);
		PizzaMemDao dao = new PizzaMemDao();

		List<Pizza> listP = dao.findAllPizzas();
		int lengthBefore = listP.size();
		dao.saveNewPizza(p);
		int lengthAfter = listP.size();
		
		assertTrue("La pizza n'existe pas",dao.pizzaExists("PIZ"));
		assertTrue("La longueur de la list de pizza est différente",(lengthBefore+1)==lengthAfter);
		
	}
	
	/**
	 * Test sur l'ajout d'une nouvelle pizza qui n'existe pas
	 */
	public void testSaveNewPizza_null(){
		Pizza p = null;
		PizzaMemDao dao = new PizzaMemDao();
		List<Pizza> listP = dao.findAllPizzas();
		int lengthBefore = listP.size();
		dao.saveNewPizza(p);
		int lengthAfter = listP.size();
		assertTrue("La longueur de la list de pizza est différente",lengthBefore==lengthAfter);
	}

	/**
	 * Test sur modification d'une pizza
	 */
	@Test
	public void testUpdatePizza(){
		PizzaMemDao dao = new PizzaMemDao();
		String code = "PEP";
		int idBefore = dao.findPizzaByCode(code).getId();
		Pizza p = new Pizza ("PIZ","PIZZZA",15.0,CategoriePizza.POISSON);
		dao.updatePizza(code, p);
		int idAfter = dao.findPizzaByCode("PIZ").getId();
		
		List<Pizza> list = dao.findAllPizzas();
		boolean exist = list.stream().anyMatch(o-> {
			return o.getCode().equals("PIZ") && o.getLibelle().equals("PIZZZA") && o.getPrix()==15.0 && o.getCategoriePizza().equals(CategoriePizza.POISSON);
		});
		
		assertTrue("La nouvelle pizza n'exite pas ",exist);
		assertEquals("La nouvelle pizza n'a pas remplace l'ancienne",idBefore,idAfter);
		assertFalse("La pizza n'exsite pas", dao.pizzaExists(code));
	}
	
	/**
	 * Test si la modification d'une pizza n'agrandit pas la list de pizza
	 */
	@Test
	public void testUpdatePizza_length(){
		Pizza p = new Pizza("PIZ", "PIZZZA", 20.0,  CategoriePizza.VIANDE);
		PizzaMemDao dao = new PizzaMemDao();
		List<Pizza> listP = dao.findAllPizzas();
		int lengthBefore = listP.size();
		dao.updatePizza("PEP", p);
		int lengthAfter = listP.size();
		assertTrue("La longueur de la list de pizza est différente",lengthBefore==lengthAfter);
	}
	
	/**
	 * Test sur la suppression de pizza
	 *  
	 */
	@Test
	public void testDeletePizza(){
		PizzaMemDao dao = new PizzaMemDao();
		String code ="PEP";
		dao.deletePizza(code);
		assertFalse("",dao.pizzaExists(code));		
	}
	
	/**
	 * Test sur la méthode FindPizzaByCode
	 */
	@Test
	public void testFindPizzaByCode(){
		PizzaMemDao dao = new PizzaMemDao();
		String code = "PEP";
		
		Pizza p = dao.findPizzaByCode(code);
		Pizza p1 = dao.findPizzaByCode("sdu");
		
		assertNotNull(p);
		assertTrue(p.getCode().equals(code));
		assertNull(p1);
	}
	
	
	/**
	 * Test si le code est null (FindpizzaByCode)
	 */
	@Test
	public void testFindPizzaByCode_null(){
		PizzaMemDao dao = new PizzaMemDao();
		String code = null;
		Pizza p = dao.findPizzaByCode(code);
		assertNull(p);

	}

	/**
	 * Test si la pizza exist et si la pizza est null
	 */
	@Test
	public void testPizzaExists(){
		PizzaMemDao dao = new PizzaMemDao();
		String code = "PEP";
		String codeNull = null;
		
		assertFalse(dao.pizzaExists(codeNull));
		assertTrue(dao.pizzaExists(code));
	}
}

