package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.util.Iterator;

import fr.pizzeria.utils.*;

public class Pizza {
	private int id;
	

	
	@ToString(toUpperCase=true, toSeparate=" -> ")
	private String code;
	
	@ToString(toUpperCase=false)
	private String libelle;

	private CategoriePizza categoriePizza;
	
	@ToString(isPrice = true,beforePrice=" (", afterPrice="€)")
	private double prix;
	
	private static int idCpt;
	
	
	public Pizza(String code, String libelle, double prix, CategoriePizza cp){
		id = idCpt++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categoriePizza = cp;

	}
	
	public Pizza (int id,String code, String libelle, double prix, CategoriePizza cp ){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categoriePizza = cp;
		

	}
	public Pizza() {}
	
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
	
	@Override
	public String toString() {
		
		return StringUtils.annotationStringUtils(this);
	
	}
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}


	
}
