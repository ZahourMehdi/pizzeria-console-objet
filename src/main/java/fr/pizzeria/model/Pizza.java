package fr.pizzeria.model;

public class Pizza {
	private int id;
	private double prix;
	private String code;
	private String libelle;
	private static int idCpt;
	
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
	public Pizza() {}
	
	@Override
	public String toString() {
		return code + " -> " + libelle + " (" + prix + "€)";
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


	
}
