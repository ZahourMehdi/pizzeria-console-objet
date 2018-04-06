package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("VIANDE"),
	POISSON("POISSON"),
	SANS_VIANDE("SANS VIANDE");
	
	private String categorie;
	
	private CategoriePizza(String categorie){
		this.categorie = categorie;
	}
	 
	public void setCategorie(String s){
		categorie=s;
	}
	public String getCategorie(){
		return categorie;
	}
}
