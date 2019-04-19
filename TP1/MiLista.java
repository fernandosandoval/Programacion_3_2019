package tp1;

public class MiLista implements Iterable<Object> {

	private MiNodo first;
	private int size;
	
	public MiLista() {
		this.first = null;
		this.size = 0;
	}
	
	/**
	 * Agrega la información recibida por parametro al principio de la lista.
	 * @param info Objeto que se quiere almacenar.
	 */
	public void addFront(Object info) {
		MiNodo nuevoNodo = new MiNodo(info,this.first);
		this.first = nuevoNodo;
		this.size++;
	}
	
	/**
	 * Elimina el primer elemento de la lista y retorna el valor que tenia almacenado.
	 * @return El valor que habia almacenado en el primer elemento de la lista.
	 */
	public Object removeFront() {
		Object info = this.first.getInfo();
		this.first = this.first.getNext();
		this.size--;
		return info;
	}

	/**
	 * Retorna la informacion almacenada en la posicion determinada por index.
	 * El primer elemento de la lista es la posicion 0.
	 * @param index Posicion del elemento que se quiere.
	 * @return Valor almacenado en la posicion index.
	 */
	public Object get(int index) {
		int contador = 0; // Si se quiere que la primer posicion sea la 1 (y no la 0) inicializar el contador en 1.
		
		MiNodo temporal = this.first;
		while (contador < index) {
			contador++;
			temporal = temporal.getNext();
		}
		
		return temporal.getInfo();
	}

	/**
	 * Retorna el tamaño de la lista recorriendola desde inicio a fin.
	 * Complejidad O(n) siendo n la cantidad de nodos en la lista.
	 * @return Tamaño de la lista.
	 */
	public int count() {
		int contador = 0;
		
		MiNodo temporal = this.first;
		while (temporal != null) {
			contador++;
			temporal = temporal.getNext();
		}
		
		return contador;
	}
	
	/**
	 * Retorna el tamaño de la lista retornando el valor de la variable size. 
	 * Complejidad O(1).
	 * @return Tamaño de la lista.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Retorna true si la lista esta vacia, o false si la lista tiene al menos un elemento.
	 * @return Boolean que responde a la pregunta ¿Esta vacia la lista?
	 */
	public boolean isEmpty() {
		return this.first == null;
		// Alternativa: return this.size == 0;
	}
	
	/**
	 * Genera en base a dos listas l1 y l2, una tercer lista l3.
	 * que contiene los elementos de l1 que no se encuentran en l2
	 */
	public void generateList(MiLista l1, MiLista l2) {
		 MiLista li3 = new MiLista();
		 MiNodo aux1 = l1.first;
		 MiNodo aux2 = l2.first;
		 boolean esta = false;
	   	 while (aux1 != null) {
	   		while (aux2 != null) {
	   			 if (aux1.getInfo().equals(aux2.getInfo())) {
	   				 esta = true;
	   			 }
	   			 aux2 = aux2.getNext();
	   	   		 }
	   		if (!(esta)) {
	   			li3.addFront(aux1.getInfo());
	   			
	   		}
	   		aux2 = l2.first;
	   		aux1 = aux1.getNext();
	   		esta = false;
	   	 }
	li3.print();
	}
	
	public void print() {
		MiIterador it = this.iterator();
		System.out.print("|");
		while (it.hasNext()) {
			System.out.print(it.next()+"|");
		}
		System.out.println("\n");
	}

	@Override
	public MiIterador iterator() {
		// Creo un iterador para recorrer mi lista. Para eso le doy una referencia a mi primer nodo.
		// ¿Porque no es ruptura de encapsulamiento?
		// Porque nadie esta accediendo a mi nodo desde afuera.
		// YO (como lista) se lo doy a la clase MiIterador (clase en la cual confio que no va a hacer nada indebido)
		return new MiIterador(this.first);
	}
	
}
