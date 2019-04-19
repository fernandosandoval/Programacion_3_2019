package tp1;

public class MiNodo {

	private Object info;
	private MiNodo next;

	public MiNodo() {
		this(null,null);
	}
	
	public MiNodo(Object info) {
		this(info,null);
	}
	
	public MiNodo(Object info, MiNodo next) {
		this.info = info;
		this.next = next;
	}
	
	public MiNodo getNext() {
		return next;
	}

	public void setNext(MiNodo next) {
		this.next = next;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

}
