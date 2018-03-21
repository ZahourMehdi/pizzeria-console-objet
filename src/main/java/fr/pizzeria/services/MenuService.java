package fr.pizzeria.services;

import java.util.Scanner;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;
public abstract class MenuService {
	
	public abstract void executeUC(PizzaMemDao listPizzaDao, Scanner option) throws StockageException;
}
