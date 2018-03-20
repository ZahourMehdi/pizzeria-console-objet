package fr.pizzeria.model;

public class Pizza {
	int id;
	double prix;
	String code;
	String libelle;
	static int idCpt;
	
	public Pizza(String code, String libelle, double prix){
		id = idCpt++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;

	}
	
	public Pizza (int id,String code, String libelle, double prix ){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;

	}
	
}
