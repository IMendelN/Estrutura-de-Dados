package lists.nohs;

import baseClass.*;

public class NohCategory {
	private Category info;
	private NohCategory next;
	private NohCategory previous;

	public NohCategory(Category info) {
		this.info = info;
		this.next = null;
		this.previous = null;
	}

	public Category getInfo() {
		return info;
	}

	public NohCategory getNext() { 
		return next;
	}

	public void setPrev(NohCategory previous) {
		this.previous = previous;
	}
	
	public NohCategory getPrev() { 
		return previous;
	}

	public void setNext(NohCategory next) {
		this.next = next;
	}
	
	public String toString() {
		return info.toString();
	}

}