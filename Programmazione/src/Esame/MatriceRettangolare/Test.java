package Esame.MatriceRettangolare;

public class Test {
	public static void main(String[] args) {
		Matrice a = new Matrice(125000, 1);
		long startTime = System.nanoTime();
		a.colonna(0);
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
	}
}
