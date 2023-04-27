package lists.nohs;

import baseClass.Client;

public class NohClient {
	private Client info;
	private NohClient next;
	private NohClient previous;

	public NohClient(Client info) {
		this.info = info;
		this.next = null;
		this.previous = null;
	}

	public Client getInfo() {
		return info;
	}

	public NohClient getNext() { 
		return next;
	}

	public void setPrev(NohClient previous) {
		this.previous = previous;
	}
	
	public NohClient getPrev() { 
		return previous;
	}

	public void setNext(NohClient next) {
		this.next = next;
	}
	
	public String toString() {
		return info.toString();
	}

}