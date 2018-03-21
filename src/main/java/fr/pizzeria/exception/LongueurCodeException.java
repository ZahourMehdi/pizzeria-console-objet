package fr.pizzeria.exception;

public class LongueurCodeException extends StockageException {
	public LongueurCodeException(){
		super("Le code pizza est trop long.\n");
	}
}
