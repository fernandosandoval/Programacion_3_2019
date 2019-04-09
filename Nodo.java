package tp1;

public class Nodo
{
    protected Object info;
    protected Nodo next;
    
    
    public Nodo() {
    	info = null;
    	next = null;
    }
    
    public Nodo(Object O, Nodo N) {
    	setInfo(O);
        setNext(N);
    }
    
    public void setInfo(Object O) {
    	info = O;
    }
    
    public void setNext(Nodo N) {
    	next = N;
    }
    
    public Object getInfo() {
    	return info;
    }
    
    public Nodo getNext() {
    	return next;
    }
    
    public int compareTo(Object O){
		 
        int estado=-1;
        if(this.info.equals(O)){
            //Los objetos son iguales
            estado = 0;
        }else if((int)this.info > (int) O){
            //El objeto A es mayor que el B pasado por parametro
            estado = 1;
        }
        return estado;
    }    
}
