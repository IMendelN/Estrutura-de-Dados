package lists.nohs;

import baseClass.Tenancy;

public class NohTenancy {
	private Tenancy info;
	private NohTenancy next;
	private NohTenancy previous;

	public NohTenancy(Tenancy info) {
		this.info = info;
		this.next = null;
		this.previous = null;
	}

	public Tenancy getInfo() {
		return info;
	}

	public NohTenancy getNext() { 
		return next;
	}

	public void setPrev(NohTenancy previous) {
		this.previous = previous;
	}
	
	public NohTenancy getPrev() { 
		return previous;
	}

	public void setNext(NohTenancy next) {
		this.next = next;
	}
	
	public String toString() {
		return info.toString();
	}

}