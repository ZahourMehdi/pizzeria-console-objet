package fr.pizzeria.model;

import javax.persistence.Embeddable;

// TODO: Auto-generated Javadoc
/**
 * The Enum CategoriePizza.
 * @author Zahour Mehdi
 */

public enum CategoriePizza {
	
	/** The viande. */
	VIANDE("VIANDE"),
	
	/** The poisson. */
	POISSON("POISSON"),
	
	/** The sans viande. */
	SANS_VIANDE("SANS VIANDE");
	
	/** The categorie. */
	private String categorie;
	
	/**
	 * Instantiates a new categorie pizza.
	 *
	 * @param categorie the categorie
	 */
	private CategoriePizza(String categorie){
		this.categorie = categorie;
	}
	 
	/**
	 * Sets the categorie.
	 *
	 * @param s the new categorie
	 */
	public void setCategorie(String s){
		categorie=s;
	}
	
	/**
	 * Gets the categorie.
	 *
	 * @return the categorie
	 */
	public String getCategorie(){
		return categorie;
	}
}
