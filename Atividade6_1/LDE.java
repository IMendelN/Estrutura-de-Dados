package Atividade6_1;

public class LDE implements List {
	private Noh start;
	private Noh end;

	public LDE() {
		this.start = null;
		this.end = null;
	}

	public Noh getStart() {
		return start;
	}

	public Noh getEnd() {
		return end;
	}

	public void insertStart(Object info) { // info = 10
		Noh newest = new Noh(info);
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

	public void insertEnd(Object info) {
		Noh newest = new Noh(info);
		if (end == null) {
			start = newest;
			end = newest;
		} else {
			newest.setPrev(end);
			end.setNext(newest);
			end = newest;
		}
	}

	public boolean remove(Object info) {
		Noh p = search(info);
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

	public Noh search(Object info) {
		Noh result = null;
		for (Noh i = start; i != null && i.getInfo() != info; i = i.getNext()) {
			if (i == info)
				result = i;
		}
		return result;
	}

	public int size() {
		int cont = 0;
		for (Noh i = start; i != null; i = i.getNext())
			cont++;
		return cont;
	}

	public void printStartToEnd() {
		for (Noh i = start; i != null; i = i.getNext())
			System.out.println(i.toString() + "\n");
	}

	public void printEndToStart() {
		for (Noh i = end; i != null; i = i.getPrev())
			System.out.println(i.toString() + "\n");
	}
}