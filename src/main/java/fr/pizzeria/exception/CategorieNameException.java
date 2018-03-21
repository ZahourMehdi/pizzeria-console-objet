package fr.pizzeria.exception;

public class CategorieNameException extends StockageException {
	public CategorieNameException(){
		super("Le nom de la catégorie est mauvais");
	}
}
