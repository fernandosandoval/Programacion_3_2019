package tp1;

public class EjemploTimer {
	
	public static void main(String [] args) {
		Timer timer = new Timer();
		timer.start();
		
		int size= 10;
		int[] array = new int [size];
		for(int i=0; i>size; i++) {
			array[i] = i;
		}
		
		double elapsedTime = timer.stop();
		System.out.println("El tiempo de ejecucion fue: ");
		System.out.println(elapsedTime);
		
		}	
		
}
