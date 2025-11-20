package Esame.Insieme;

public class InsiemeTest {
	public static void main(String[] args) {
		printTitle("aggiungi");
		testAdd();
		printLine();
		printTitle("rimuovi");
		testRimuovi();
		printLine();
		printTitle("contiene");
		testContiene();
		printLine();
		printTitle("intersezione");
		testIntersezione();
		printLine();
		printTitle("unione");
		testUnione();
		printLine();
	}
	private static void testAdd(){
		Insieme i1 = new Insieme(10);
		boolean result = false;
		for(int i = 0; i < 9; i++){
			result = i1.aggiungi(i);
			if(!result){
				System.out.println("Impossibile aggiungere valore "+i);
				return;
			}
		}
		result = i1.aggiungi(8);
		if(result){
			System.out.println("Aggiunto valore duplicato");
			return;
		}
		result = i1.aggiungi(9);
		result = i1.aggiungi(10);
		if(result){
			System.out.println("Aggiunti più elementi del limite massimo");
		}
		System.out.println("Ok");
	}
	private static void testRimuovi() {
		Insieme i1 = new Insieme(10);
		boolean result = i1.rimuovi(42);
		if(result){
			System.out.println("Rimosso elemento non esistente");
			return;
		}
		i1.aggiungi(42);
		result = i1.rimuovi(42);
		if(!result){
			System.out.println("Rimozione non riuscita");
		}
		for(int i = 0; i < 9; i++){
			result = i1.aggiungi(i);
		}
		result = i1.rimuovi(5);
		if(!result){
			System.out.println("Rimozione non riuscita");
		}

	}
	private static void testContiene() {
	}

	private static void testIntersezione() {

	}
	private static void testUnione() {
	}

	private static void printTitle(String name) {
		printLine();
		System.out.println("Test "+name);
		printLine();
	}

	private static void printLine(){
		System.out.println("----------------------------------------");
	}
}
