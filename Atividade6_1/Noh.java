package Atividade6_1;

public class Noh {
	private Object info;
	private Noh next;
	private Noh previous;

	public Noh(Object info) {
		this.info = info;
		this.next = null;
		this.previous = null;
	}

	public Object getInfo() {
		return info;
	}

	public Noh getNext() {
		return next;
	}

	public void setPrev(Noh n) {
		this.previous = n;
	}

	public Noh getPrev() {
		return previous;
	}

	public void setNext(Noh n) {
		this.next = n;
	}

	public String toString() {
		return info.toString();
	}

}