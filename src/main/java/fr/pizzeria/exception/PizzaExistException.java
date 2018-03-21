package fr.pizzeria.exception;

public class PizzaExistException extends StockageException {
	public PizzaExistException(){
		super("La pizza existe déjà");
	}
}
