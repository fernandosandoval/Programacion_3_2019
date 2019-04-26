package TP2;

public class Arbol {
    
	/**
	 * Esta implementacion del arbol consiste de un nodo raíz de tipo Nodo. 
	 * La clase Nodo consta de un dato de tipo integer
	 * y dos hijos de tipo Arbol, los cuales se inicializan en null
	 */
	
	private class Nodo{
		private Object dato;
		private Arbol hijoIzq;
		private Arbol hijoDer;
		
		protected Nodo() {
			dato = null;
			hijoIzq = null;
			hijoDer = null;
		}
		
		private Arbol getHijoIzq() {
			return this.hijoIzq;
		}
		
		private Arbol getHijoDer() {
			return this.hijoDer;
		}
		
		private Object getDato() {
			return this.dato;
		}
		
		private void setDato(Object dato) {
			this.dato = dato;
		}
		
		public int compareTo(int n){
			 
	        int estado=-1;
	        if(this.dato.equals(n)){
	            //Los objetos son iguales
	            estado = 0;
	        }else if((int)this.getDato() > n){
	            //El objeto A es mayor que el B pasado por parametro
	            estado = 1;
	        }
	        return estado;
	    }    
	}
	
	private Nodo raiz;
	
	// constructores
	
    public Arbol() {
    	raiz = new Nodo();
    }
	
	public Arbol(Object o) {
         raiz.setDato(o);
         setHijoDer();
         setHijoIzq();
	}
	
	// getters y setters
 
	public Arbol getHijoIzq() {
	    	return raiz.getHijoIzq();
	    }
	    
	public Arbol getHijoDer() {
	    	return raiz.getHijoDer(); 
	    }
	    
	public void setHijoIzq() {
	    	raiz.hijoIzq = null;
	    }
	    
	public void setHijoDer() {
	    	raiz.hijoDer = null;
	    }
	
	//Métodos solicitados en el ejercicio 6 del TP2
	 
	public Nodo getRoot() {
    	return raiz;
    }
    
    public boolean isEmpty(){
        return (raiz.dato == null);
    }
    
    public void insert(int n1){
        if (isEmpty()) {
            Nodo nuevo = new Nodo();
            nuevo.dato = n1;
            nuevo.hijoIzq = new Arbol();
            nuevo.hijoDer = new Arbol();
            raiz = nuevo;
        }
        else {
            if (this.raiz.compareTo(n1)==1) {
                (raiz.getHijoIzq()).insert(n1);
            }
            if (this.raiz.compareTo(n1)==-1){
                (raiz.getHijoDer()).insert(n1);
            }
        }
    }
 
    public void preOrder(){
        if (!isEmpty()) {
            System.out.print( raiz.getDato() + ", "  );
            raiz.getHijoIzq().preOrder();
            raiz.getHijoDer().preOrder();
        }
    }
 
    public void inOrder(){
        if (!isEmpty()) {
            raiz.getHijoIzq().inOrder();
            System.out.print( raiz.getDato() + ", "  );
            raiz.getHijoDer().inOrder();
        }
    }
 
    public void posOrder(){
        if (!isEmpty()) {
            raiz.getHijoDer().posOrder();
            raiz.getHijoIzq().posOrder();
            System.out.print( raiz.getDato() + ", "  );
 
        }
    }
 
    public Arbol find(int a){
    	Arbol aux = null;
        if (!isEmpty()) {
            if ((int)raiz.getDato() == a) {
            return this;
            }
            else {
            	//como el parametro es int, casteo a int el valor del nodo raiz
                if ((int) raiz.getDato() < a) {
                   aux = this.raiz.getHijoIzq().find(a);
                }
                else {
                   aux = this.raiz.getHijoDer().find(a);
                }
            }
        }
        return aux;
    }
 
    public boolean hasElem(int n){
    	while (!isEmpty()) {
            if (this.raiz.compareTo(n)==-1) {
            	return(this.raiz.getHijoIzq().hasElem(n));
            }
            else if (this.raiz.compareTo(n)==1) {
                    return(this.raiz.getHijoDer().hasElem(n));
                }
                else {
                	return true;
                }  
        }
    	return false;
    }
    
    
    public int findMin() {
        Arbol arbolActual = this;
        while( !arbolActual.getHijoIzq().isEmpty() ) {
            arbolActual = arbolActual.getHijoIzq();
        }
        int devuelvo= (int)arbolActual.raiz.getDato();
        arbolActual.raiz=null;
        return devuelvo;
    }
    
    public boolean isLeaf() {
        boolean hoja = false;
        if( (this.getHijoIzq()).isEmpty() && (this.getHijoDer()).isEmpty() ) {
            hoja = true;
        }
        return hoja;
    }
    
    public void getFrontier() {
    	if (!isEmpty()) {
            raiz.getHijoIzq().getFrontier();
            raiz.getHijoDer().getFrontier();
            if(isLeaf()) {
               System.out.print( raiz.getDato() + ", "  );
            } 
        }
    }
 
    
    public void delete(int a) {
    	Arbol toDelete = find(a);
        if (!toDelete.isEmpty()) {
            if (toDelete.isLeaf()) {
            	toDelete.raiz = null;
            }
            else {
                if (!toDelete.getHijoIzq().isEmpty() && !toDelete.getHijoDer().isEmpty()) {
                	toDelete.raiz.dato = toDelete.getHijoDer().findMin();
                }
                else {
                    if (toDelete.getHijoIzq().isEmpty()) {
                    	toDelete.raiz = toDelete.getHijoDer().raiz;
                    }else{
                    	toDelete.raiz = toDelete.getHijoIzq().raiz;
                    }
                }
            }
        }
    }
}
