package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import fr.pizzeria.exception.NullCodeException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

// TODO: Auto-generated Javadoc
/**
 * The Class PizzaJpaDao.
 * @author Zahour Mehdi
 */
public class PizzaJpaDao implements IPizzaDao {

	
	/** The Constant LOG. */
	private static  final Logger LOG = LoggerFactory.getLogger(PizzaJpaDao.class);
	
	/**
	 * Instantiates a new pizza jpa dao.
	 */
	public PizzaJpaDao() {}

	/* 
	 * Permet de chercher dans la base données toutes les pizzas
	 */
	@Override
	public List<Pizza> findAllPizzas() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query query = em.createQuery("select p from Pizza p");
		
		List<Pizza> listPizza= (List<Pizza>) query.getResultList();
		
		
		em.close();
		entityManagerFactory.close();
		return listPizza;
	}

	/* 
	 * Sauvegarde une nouvelle pizza en base
	 */
	@Override
	public void saveNewPizza(Pizza pizza) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(pizza);
		et.commit();
		em.close();
		entityManagerFactory.close();

	}

	/* 
	 * Modifie une pizza en base
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws NullCodeException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query q = em.createQuery("UPDATE Pizza p SET p.code=:codeP, p.libelle=:libelleP, p.prix=:prixP, p.categoriePizza=:categorieP WHERE p.code=:codePizza ");
		q.setParameter("codeP",pizza.getCode() );
		q.setParameter("libelleP",pizza.getLibelle() );
		q.setParameter("prixP",pizza.getPrix() );
		q.setParameter("categorieP",pizza.getCategoriePizza() );
		q.setParameter("codePizza",codePizza );
		
		q.executeUpdate();
		
		et.commit();
		em.close();
		entityManagerFactory.close();
	}

	/* 
	 * Supprime une pizza de la base
	 */
	@Override
	public void deletePizza(String codePizza) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query q = em.createQuery("DELETE FROM Pizza p WHERE p.code=:codePizza");
		q.setParameter("codePizza", codePizza);
		q.executeUpdate();
		
		et.commit();
		em.close();
		entityManagerFactory.close();
	}

	/* 
	 * Cherche une pizza en fonction de son code
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query query = em.createQuery("select p from Pizza p WHERE code=:codePizza");
		query.setParameter("codePizza",codePizza);
		Pizza p = (Pizza) query.getSingleResult();
		
		em.close();
		entityManagerFactory.close();
		return p;
		
	}

	/* 
	 * Verifie si une pizza existe dans la base
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		boolean exist =false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query query = em.createQuery("select p from Pizza p WHERE code=:codePizza");
		query.setParameter("codePizza",codePizza);
		
		if ( query.getResultList().size()==0) 
			exist = false;
		else
			exist = true;
		
		em.close();
		entityManagerFactory.close();

		return exist;
	}

}
