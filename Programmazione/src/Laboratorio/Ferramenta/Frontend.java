package Laboratorio.Ferramenta;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;
import java.util.function.Predicate;

public class Frontend {
	public static void main(String[] args){
		Catalogo cat = new Catalogo(3);
		Articolo[] art = new Articolo[]{
				new Chiodo(1, 2, 1),
				new Lampadina(1, 2, 1),
				new Vernice(1, 2, 1)
		};
		for(int i = 0; i < 3; i++){
			cat.caricamento(art[i]);
		}
		cat.caricamento(new Lampadina(1, 2, 5));
		double total = cat.vendita(new Lampadina(1, 2, 3));
		if(total == 6){
			System.out.println("Ok");
		}
	}
}
