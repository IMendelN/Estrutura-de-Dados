package lists.lde;

import baseClass.*;
import lists.nohs.NohTenancy;

public class LDETenancy {
	private NohTenancy start;
	private NohTenancy end;

	public LDETenancy() {
		this.start = null;
		this.end = null;
	}

	public void insertStart(Tenancy info) {
		NohTenancy newest = new NohTenancy(info);
		if (start == null) {
			start = newest;
			end = newest;
		} else {
			newest.setNext(start);
			start.setPrev(newest);
			start = newest;
		}
	}

	public boolean isEmpty() {
		return start == null;
	}

	public void insertEnd(Tenancy info) {
		NohTenancy newest = new NohTenancy(info);
		if (end == null) {
			start = newest;
			end = newest;
		} else {
			newest.setPrev(end);
			end.setNext(newest);
			end = newest;
		}
	}

	public boolean remove(Tenancy info) {
		NohTenancy p = search(info);
		if (p == null)
			return false;
		if (p.getPrev() == null) {
			start = p.getNext();
			if (start != null)
				start.setPrev(null);
		} else if (p.getNext() == null) {
			p.getPrev().setNext(null);
			end = p.getPrev();
		} else {
			p.getPrev().setNext(p.getNext());
			p.getNext().setPrev(p.getPrev());
		}
		return true;
	}

	public NohTenancy search(Tenancy info) {
		NohTenancy result = null;
		for (NohTenancy i = start; i != null; i = i.getNext()) {
			if ((i.getInfo().getPlaque() == info.getPlaque()) && (i.getInfo().getCNH() == info.getCNH()))
				result = i;
		}
		return result;
	}

	public NohTenancy search(String plaque) {
		NohTenancy result = null;
		for (NohTenancy i = start; i != null; i = i.getNext()) {
			if (i.getInfo().getPlaque().equals(plaque))
				result = i;
		}
		return result;
	}

	public Tenancy get(String plaque) {
		NohTenancy nohTenancy = search(plaque);
		if (nohTenancy != null)
			return nohTenancy.getInfo();
		return null;
	}

	public boolean haveTenancy(String plaque) {
		if (search(plaque) != null)
			return true;
		return false;
	}

	public boolean haveTenancy(long cnh) {
		for (NohTenancy i = start; i != null; i = i.getNext()) {
			if (i.getInfo().getCNH() == cnh)
				return true;
		}
		return false;
	}

	public boolean isHired(String plaque) {
		for (NohTenancy i = start; i != null; i = i.getNext())
			if (i.getInfo().getPlaque().equals(plaque))
				return true;
		return false;
	}

	public boolean isHired(long cnh) {
		for (NohTenancy i = start; i != null; i = i.getNext())
			if (i.getInfo().getCNH() == cnh)
				return true;
		return false;
	}

	public int size() {
		int cont = 0;
		for (NohTenancy i = start; i != null; i = i.getNext())
			cont++;
		return cont;
	}

	public void printStartToEnd() {
		for (NohTenancy i = start; i != null; i = i.getNext())
			System.out.println(i.toString() + "\n");
	}

	public void printEndToStart() {
		for (NohTenancy i = end; i != null; i = i.getPrev())
			System.out.println(i.toString() + "\n");
	}
}