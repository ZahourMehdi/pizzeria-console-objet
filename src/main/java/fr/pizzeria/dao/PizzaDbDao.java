package fr.pizzeria.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.exception.NullCodeException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.services.MenuService;
import fr.pizzeria.utils.ConnexionBase;

// TODO: Auto-generated Javadoc
/**
 * The Class PizzaDbDao.
 * @author Zahour Mehdi
 */
public class PizzaDbDao implements IPizzaDao {
	
	private static  final Logger LOG = LoggerFactory.getLogger(PizzaDbDao.class);
	/**
	 * Pizza db dao.
	 * Se connecte à la base et initialise la base avec un jeu de pizza défini
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public PizzaDbDao() {
		
		ConnexionBase cb = null;
		Connection myConnection = null;
		try {

			cb = new ConnexionBase();
			myConnection= cb.connecte();
			
			Statement statement = myConnection.createStatement();
			
			// Initialisation de la base Pizza
			
			statement.executeUpdate("INSERT IGNORE INTO PIZZA (CODE_PIZZA,LIBELLE_PIZZA,PRIX_PIZZA,CATEGORIE_PIZZA) VALUES ('PEP','Pépéroni',12.50,'VIANDE')");
			statement.executeUpdate("INSERT IGNORE INTO PIZZA (CODE_PIZZA,LIBELLE_PIZZA,PRIX_PIZZA,CATEGORIE_PIZZA) VALUES ('MAR','Margherita',14.00,'SANS_VIANDE')");
			statement.executeUpdate("INSERT IGNORE INTO PIZZA (CODE_PIZZA,LIBELLE_PIZZA,PRIX_PIZZA,CATEGORIE_PIZZA) VALUES ('REI','La Reine',11.50,'VIANDE')");
			statement.executeUpdate("INSERT IGNORE INTO PIZZA (CODE_PIZZA,LIBELLE_PIZZA,PRIX_PIZZA,CATEGORIE_PIZZA) VALUES ('FRO','Les 4 fromages',12.00,'SANS_VIANDE')");
			statement.executeUpdate("INSERT IGNORE INTO PIZZA (CODE_PIZZA,LIBELLE_PIZZA,PRIX_PIZZA,CATEGORIE_PIZZA) VALUES ('CAN','La cannibale',12.50,'VIANDE')");
			statement.executeUpdate("INSERT IGNORE INTO PIZZA (CODE_PIZZA,LIBELLE_PIZZA,PRIX_PIZZA,CATEGORIE_PIZZA) VALUES ('SAV','La savoyarde',13.00,'VIANDE')");
		
		} catch ( SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("L'application ne fonctionne pas");
		}finally{
			cb.close(myConnection);
		}
	}
		
	/* 
	 * Retourne la liste de toutes les pizzas présente dans la base
	 * @return List<Pizza>
	 */
	@Override
	public List<Pizza> findAllPizzas(){
		List<Pizza> listPizza = new ArrayList();
		String code;
		String libelle;
		Double prix;

		ResourceBundle file = ResourceBundle.getBundle("jdbc");
		Connection myConnection=null;

		try {
			Class.forName(file.getString("jdbc.driver"));
			myConnection = DriverManager.getConnection(file.getString("jdbc.url"),
					file.getString("jdbc.username"), file.getString("jdbc.password"));
			Statement statement = myConnection.createStatement();

			ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA");

			while (resultats.next()) {
				code = resultats.getString("CODE_PIZZA");
				libelle = resultats.getString("LIBELLE_PIZZA");
				prix = resultats.getDouble("PRIX_PIZZA");
				Pizza p = new Pizza(code, libelle, prix, 
						CategoriePizza.valueOf(resultats.getString("CATEGORIE_PIZZA")));
				listPizza.add(p);
			}
			resultats.close();
		} catch (SQLException |	ClassNotFoundException e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		}finally{
			try {
				if(myConnection!=null)
					myConnection.close();
			} catch (SQLException e) {
				throw new RuntimeException("L'application ne fonctionne pas");
			}
		}

		return listPizza;
	}

	/* 
	 * Permet d'enregistrer en base une nouvelle pizza
	 * @param Pizza pizza : nouvelle pizza
	 */
	@Override
	public void saveNewPizza(Pizza pizza){
		ResourceBundle file = ResourceBundle.getBundle("jdbc");
		PreparedStatement insertPizza =null;
		Connection myConnection=null;
		try {
			Class.forName(file.getString("jdbc.driver"));
			myConnection = DriverManager.getConnection(file.getString("jdbc.url"),
					file.getString("jdbc.username"), file.getString("jdbc.password"));
			insertPizza = myConnection.prepareStatement(
					"INSERT IGNORE INTO PIZZA (CODE_PIZZA,LIBELLE_PIZZA,PRIX_PIZZA,CATEGORIE_PIZZA) VALUES (?,?,?,?)");
			insertPizza.setString(1, pizza.getCode());
			insertPizza.setString(2, pizza.getLibelle());
			insertPizza.setDouble(3, pizza.getPrix());
			insertPizza.setString(4, pizza.getCategoriePizza().getCategorie());
			insertPizza.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		}finally{
			try {
				insertPizza.close();
				myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/* 
	 * Permet de modifier une pizza
	 * @param String codePizza : code de la pizza que l'on veut modifier
	 * @param Pizza pizza : nouvelle pizza
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		ResourceBundle file = ResourceBundle.getBundle("jdbc");
		Connection myConnection=null;
		PreparedStatement updatePizza=null;
		try {
			Class.forName(file.getString("jdbc.driver"));
			myConnection = DriverManager.getConnection(file.getString("jdbc.url"),
					file.getString("jdbc.username"), file.getString("jdbc.password"));
			updatePizza = myConnection.prepareStatement(
					"UPDATE PIZZA SET CODE_PIZZA=?, LIBELLE_PIZZA=?, PRIX_PIZZA=?, CATEGORIE_PIZZA=? WHERE CODE_PIZZA = ?");

			updatePizza.setString(1, pizza.getCode());
			updatePizza.setString(2, pizza.getLibelle());
			updatePizza.setDouble(3, pizza.getPrix());
			updatePizza.setString(4, pizza.getCategoriePizza().toString());
			updatePizza.setString(5, codePizza);
			updatePizza.executeUpdate();
			
			updatePizza.close();
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("L'application ne fonctionne pas");
		}finally{
			try {
				updatePizza.close();
				myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/* 
	 * Permet de supprimer une pizza
	 * @param String codePizza : code de la pizza que l'on veut supprimer
	 */
	@Override
	public void deletePizza(String codePizza){
		ResourceBundle file = ResourceBundle.getBundle("jdbc");
		Connection myConnection=null;
		try {
			Class.forName(file.getString("jdbc.driver"));
			myConnection = DriverManager.getConnection(file.getString("jdbc.url"),
					file.getString("jdbc.username"), file.getString("jdbc.password"));
			PreparedStatement deletePizza = myConnection.prepareStatement("DELETE FROM pizza WHERE CODE_PIZZA = ?");
			deletePizza.setString(1, codePizza);
			deletePizza.executeUpdate();
			
			deletePizza.close();
		} catch (SQLException | ClassNotFoundException e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		}finally{
			try {
				myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/* 
	 *Permet de chercher une pizza grace à son code
	 *@param String codePizza : code de la pizza à chercher
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza){
		
		String code;
		String libelle;
		Double prix;
		Pizza p =null;
		ResourceBundle file = ResourceBundle.getBundle("jdbc");
		Connection myConnection =null;
		try {
			Class.forName(file.getString("jdbc.driver"));
			myConnection = DriverManager.getConnection(file.getString("jdbc.url"),
					file.getString("jdbc.username"), file.getString("jdbc.password"));
			Statement statement = myConnection.createStatement();
			ResultSet resultats = statement.executeQuery("SELECT * FROM PIZZA ");
			while(resultats.next()){
				if (resultats.getString("CODE_PIZZA").equals(codePizza)){
					code = resultats.getString("CODE_PIZZA");
					libelle = resultats.getString("LIBELLE_PIZZA");
					prix = resultats.getDouble("PRIX_CODE");
					 p = new Pizza(code, libelle, prix,
							CategoriePizza.valueOf(resultats.getString("CATEGORIE_PIZZA")));
				}
			};

		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("L'application ne fonctionne");
		}finally{
			try {
				myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return p;
	}

	/* 
	 * Permet de vérifier l'existence d'une pizza grace a son code
	 * @param String codePizza : Code utiliser pour savoir si la pizza existe
	 */
	@Override
	public boolean pizzaExists(String codePizza) {
		boolean res = true;
		ResourceBundle file = ResourceBundle.getBundle("jdbc");
		Connection myConnection =null;
		ResultSet resultats =null;
		PreparedStatement existsPizza = null;
		try {
			Class.forName(file.getString("jdbc.driver"));
			myConnection = DriverManager.getConnection(file.getString("jdbc.url"),
					file.getString("jdbc.username"), file.getString("jdbc.password"));
			
			existsPizza = myConnection.prepareStatement("SELECT *  FROM pizza WHERE CODE_PIZZA = ?");
			existsPizza.setString(1, codePizza);
			
			resultats = existsPizza.executeQuery();
				
			res = resultats.next();

		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("L'application ne fonctionne");
		}finally{
			try {
				
				resultats.close();
				existsPizza.close();
				myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

}
