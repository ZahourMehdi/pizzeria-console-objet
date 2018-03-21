package fr.pizzeria.exception;

public class PrixNegativeException extends StockageException  {
	public PrixNegativeException(){
		super("Le prix doit etre positif");
	}
}
