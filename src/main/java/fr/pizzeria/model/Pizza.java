package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.pizzeria.utils.*;


// TODO: Auto-generated Javadoc
/**
 * The Class Pizza.
 * @author Zahour Mehdi
 */
@Entity
@Table(name="pizza")
public class Pizza {
	
	/** The id. */
	@Id
	@Column(name="ID_PIZZA") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	/** The code. */
	@Column(name="CODE_PIZZA", length=3, nullable=false, unique=true)
	@ToString(toUpperCase=true, toSeparate=" -> ")
	private String code;
	
	
	/** The libelle. */
	@Column(name="LIBELLE_PIZZA", length=50, nullable=false)
	@ToString(toUpperCase=false)
	private String libelle;

	/** The categorie pizza. */
	@Column(name="CATEGORIE_PIZZA")
	@Enumerated(EnumType.STRING)
	private CategoriePizza categoriePizza;
	
	/** The prix. */
	@Column(name="PRIX_PIZZA", nullable=false)
	@ToString(isPrice = true,beforePrice=" (", afterPrice="€)")
	private double prix;
	
	/** The id cpt. */
	private static int idCpt;
	
	
	/**
	 * Instantiates a new pizza.
	 *
	 * @param code the code
	 * @param libelle the libelle
	 * @param prix the prix
	 * @param cp the cp
	 */
	public Pizza(String code, String libelle, double prix, CategoriePizza cp){
		id = idCpt++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categoriePizza = cp;

	}
	
	/**
	 * Instantiates a new pizza.
	 *
	 * @param id the id
	 * @param code the code
	 * @param libelle the libelle
	 * @param prix the prix
	 * @param cp the cp
	 */
	public Pizza (int id,String code, String libelle, double prix, CategoriePizza cp ){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categoriePizza = cp;
		

	}
	
	/**
	 * Instantiates a new pizza.
	 */
	public Pizza() {}
	
	/* (non-Javadoc)
	 * Permet de verifier si deux objets Pizza sont egauxs
	 */
	public boolean equals(Object object){
		//Permet de vérifier à la fois que object est non null et
		// que c'est une instance de Pizza
		
		if (!(object instanceof Pizza)) {
			return false;
		}
		Pizza other = (Pizza)object;
		if (this.code.equals(other.getCode())
			&& this.libelle.equals(other.getLibelle())
			&& this.prix == other.getPrix())
			return true;
		return false;
	}
	
	/* 
	 * @return une pizza sous forme de chaine de caractere
	 */
	@Override
	public String toString() {
		
		return StringUtils.annotationStringUtils(this);
	
	}
	

	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the prix.
	 *
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * Sets the prix.
	 *
	 * @param prix the new prix
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the libelle.
	 *
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 *
	 * @param libelle the new libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the categorie pizza.
	 *
	 * @return the categorie pizza
	 */
	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	/**
	 * Sets the categorie pizza.
	 *
	 * @param categoriePizza the new categorie pizza
	 */
	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}


	
}
