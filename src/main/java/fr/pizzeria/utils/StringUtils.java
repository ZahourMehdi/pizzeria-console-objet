package fr.pizzeria.utils;

import java.lang.reflect.Field;


public class StringUtils {
	public static String annotationStringUtils(Object o){
		
		Class<?> cl = o.getClass();
		
		//Permet de récupérer la liste des attributs de la classe
		Field[] attributs = cl.getDeclaredFields();
		
		StringBuilder chaine = new StringBuilder();
		String upCase ="";
		String lowCase="";
		String separateur="";
		String before ="";
		String after = "";
		String price ="";
		try {
			//Boucle sur les attributs
			for(Field attr : attributs){
				
				//Permet de passer les attributs de private a public
				attr.setAccessible(true);	
				//PErmet de vérifier si une annotation est présente sur l'attribut
				if (attr.isAnnotationPresent(ToString.class)) {
					
					
					ToString annotation = attr.getAnnotation(ToString.class);
					//récupere la valeur du boolean
					boolean uppercase = annotation.toUpperCase();
					
					//récupere la valeur du boolean IsPrice
					boolean isPrice = annotation.isPrice();
					
					//récupere la valeur du séparateur
					separateur = annotation.toSeparate();
					
					//récupere la valeur de beforePrice
					before = annotation.beforePrice();
					
					//récupere la valeur de afterPrice
					after = annotation.afterPrice();
					
					//Récupération de la valeur de l'attribut pour l'instance courante
					Object value = attr.get(o);


					if (uppercase == true) {
						upCase = value.toString();
						upCase = upCase.toUpperCase();
						chaine.append(upCase).append(separateur);
					}else if(uppercase == false && isPrice==false ){
						lowCase = value.toString();
						chaine.append(lowCase);
					}else if (isPrice == true){
						price=value.toString();
						chaine.append(before).append(price).append(after);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return chaine.toString();
	}
}
