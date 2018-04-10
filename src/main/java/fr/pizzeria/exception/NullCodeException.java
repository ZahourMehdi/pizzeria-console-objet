package fr.pizzeria.exception;

public class NullCodeException extends StockageException {
	public NullCodeException(){
		super("Code null");
	}
}
