package tp1;

public class Sim {
	
	/*  Ejercicio 6 del TP1 de Programacion 3 de TUDAI 2019
	 * 
	 *  Autor: Fernando Sandoval
	 *  
	 *  Se crean dos listas, y se debe generar una tercer lista que contenga 
	 *  los elementos que estén en la primer lista, pero no en la segunda lista
	 *  
	 */

	public static void main(String[] Args) {
		Timer timer = new Timer();
		timer.start();		
		MiLista li1 = new MiLista();
		MiLista li2 = new MiLista();
		System.out.println("Lista 1");
		li1.addFront(4);
		li1.addFront(9);
		li1.addFront(8);
		li1.addFront(2);
		li1.addFront(6);
		li1.print();
		System.out.println("Lista 2");
		li2.addFront(9);
		li2.addFront(7);
		li2.addFront(8);
		li2.addFront(1);
		li2.addFront(5);
		li2.print();
		System.out.println("Lista resultado:");
		li1.generateList(li1,li2);
		double elapsedTime = timer.stop();
		System.out.println("El tiempo de ejecucion fue: ");
		System.out.println(elapsedTime);
        }
	
}	

