package fr.pizzeria.services;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;
public abstract class MenuService {
	
	protected static final Logger LOG = LoggerFactory.getLogger(MenuService.class);
	
	public abstract void executeUC(IPizzaDao listPizzaDao, Scanner option) throws StockageException;
}
