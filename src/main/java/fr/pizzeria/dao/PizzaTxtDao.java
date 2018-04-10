package fr.pizzeria.dao;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import fr.pizzeria.model.Pizza;



public class PizzaTxtDao implements IPizzaDao {
	
	public PizzaTxtDao (){
		
		ResourceBundle cf = ResourceBundle.getBundle("conf");
		String path = cf.getString("path.txt");
		
		File file =new File(path);
		List list = new ArrayList<>();
		
		
		/*try{
			//FileUtils.writeLines(file,list);
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

	@Override
	public List<Pizza> findAllPizzas() {
		
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		
	}

	@Override
	public void deletePizza(String codePizza) {

		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {

		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {

		return false;
	}
	
	//Genere un pdf de la carte des pizzas
	public void generatePdf(IPizzaDao pmd){
		
		Document document = new Document();
		
		//Recupere le chemin stocker le fichier pdf grace au fichier conf
		ResourceBundle file = ResourceBundle.getBundle("conf");
		String path = file.getString("path.pdf");
		
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(path));
			
			document.open();
			
			for (int i = 0; i < pmd.findAllPizzas().size(); i++) {
				document.add(new Paragraph(pmd.findAllPizzas().get(i).toString()));
			}
		} catch (DocumentException de) {
			de.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		document.close();
	}
}
