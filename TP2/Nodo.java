package TP2;

public class Nodo{

	private Object dato;
	
	protected Nodo() {
		dato = null;
	}
	
	protected Nodo(int i) {
		this.dato = i;
	}
		
	private Object getDato() {
		return this.dato;
	}
	
	private void setDato(Object dato) {
		this.dato = dato;
	}
	
	public int compareTo(Nodo N){
		 
        int estado=-1;
        if(this.dato.equals(N)){
            //Los objetos son iguales
            estado = 0;
        }else if((int)this.getDato() > (int) N.getDato()){
            //El objeto A es mayor que el B pasado por parametro
            estado = 1;
        }
        return estado;
    }    
}