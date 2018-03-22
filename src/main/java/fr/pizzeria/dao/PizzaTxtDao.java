package fr.pizzeria.dao;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class PizzaTxtDao {
		
	public void generatePdf(PizzaMemDao pmd){
	
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
