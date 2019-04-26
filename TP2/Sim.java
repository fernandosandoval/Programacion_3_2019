package TP2;

public class Sim {
	

	/*  Ejercicio 6 del TP2 de Programacion 3 de TUDAI
	 * 
	 *  Autor: Fernando Sandoval
	 *  
	 *  
	 *  Se implementan los metodos solicitados en la clase Arbol ()
	 *  
	 */

	public static void main(String[] args) {
		Arbol ar1 = new Arbol();
		ar1.insert(50);
		ar1.insert(25);
		ar1.insert(70);
		ar1.insert(20);
		ar1.insert(15);
		ar1.insert(30);
		ar1.insert(90);
		ar1.insert(80);
		ar1.insert(75);
		ar1.insert(100);
		ar1.insert(95);
		ar1.insert(110);
		System.out.println("Recorrido pre order:");
		ar1.preOrder();
		System.out.println();
		System.out.println("Recorrido in order:");
		ar1.inOrder();
		System.out.println();
		System.out.println("Recorrido pos order:");
		ar1.posOrder();
		System.out.println();
		System.out.println("La frontera del arbol es:");
		ar1.getFrontier();
		System.out.println();
		
	}

}
