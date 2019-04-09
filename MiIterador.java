package tp1;

import java.util.Iterator;

// Nota: si Eclipse los obliga a definir el metodo remove es porque estan utilizando Java >= 8
// Si este es el caso, dejene el metodo remove vacio.

public class MiIterador implements Iterator<Object> {

	private MiNodo nodo;
	
	public MiIterador(MiNodo nodo) {
		this.nodo = nodo;
	}
	
	/**
	 * Verifica si hay un elemento "siguiente".Por convencion, todos los iteradores en Java se ubican inicialmente en una posicion "ficticia" previa al primer elemento de la lista.
	 * La primera invocacion al hasNext de un iterador nos indica si hay un primer elemento, o si la lista esta vacia.
	 * @return Boolean respondiendo a la pregunta ¿Hay mas elementos por recorrer?
	 */
	@Override
	public boolean hasNext() {
		return this.nodo != null;
	}

	/**
	 * Este metodo se mueve al siguiente elemento de la lista y retorna su valor. Antes de invocar este método se debe verificar que hasNext() retorne true.
	 * @return Informacion almacenado en la posicion de la lista actual.
	 */
	@Override
	public Object next() {
		Object info = this.nodo.getInfo();
		this.nodo = this.nodo.getNext();
		return info;
	}

}
