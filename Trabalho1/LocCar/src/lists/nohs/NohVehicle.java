package nohs;

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

	public void setPrevious(NohVehicle n) {
		this.previous = n;
	}
	
	public NohVehicle getPrevious() { 
		return previous;
	}

	public void setNext(NohVehicle n) {
		this.next = n;
	}
	
	public String toString() {
		return info.toString();
	}

}