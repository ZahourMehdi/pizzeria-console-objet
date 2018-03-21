package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("viande"),
	POISSON("poisson"),
	SANS_VIANDE("Sans viande");
	
	private String categorie;
	
	private CategoriePizza(String categorie){
		this.categorie = categorie;
	}
	
	public String getCategorie(){
		return categorie;
	}
}
