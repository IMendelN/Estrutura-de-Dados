package lists.nohs;

import baseClass.Vehicle;

public class NohVehicle {
	private Vehicle info;
	private NohVehicle next;
	private NohVehicle previous;

	public NohVehicle(Vehicle info) {
		this.info = info;
		this.next = null;
		this.previous = null;
	}

	public Vehicle getInfo() {
		return info;
	}

	public NohVehicle getNext() { 
		return next;
	}

	public void setPrev(NohVehicle previous) {
		this.previous = previous;
	}
	
	public NohVehicle getPrev() { 
		return previous;
	}

	public void setNext(NohVehicle next) {
		this.next = next;
	}
	
	public String toString() {
		return info.toString();
	}

}