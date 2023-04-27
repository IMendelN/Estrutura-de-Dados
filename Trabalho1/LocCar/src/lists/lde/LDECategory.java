package lists.lde;

import baseClass.*;
import lists.nohs.Noh;
import lists.nohs.NohCategory;

public class LDECategory {
	private NohCategory start;
	private NohCategory end;

	public LDECategory() {
		this.start = null;
		this.end = null;
	}

	public void insertStart(Category info) {
		NohCategory newest = new NohCategory(info);
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

	public void insertEnd(Category info) {
		NohCategory newest = new NohCategory(info);
		if (end == null) {
			start = newest;
			end = newest;
		} else {
			newest.setPrev(end);
			end.setNext(newest);
			end = newest;
		}
	}

	public boolean remove(Category info) {
		NohCategory p = search(info);
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

	public NohCategory search(Category info) {
		NohCategory result = null;
		for (NohCategory i = start; i != null; i = i.getNext()) {
			if (i.getInfo().getID() == info.getID())
				result = i;
		}
		return result;
	}

	public NohCategory search(int id) {
		NohCategory result = null;
		for (NohCategory i = start; i != null; i = i.getNext()) {
			if (i.getInfo().getID() == id)
				result = i;
		}
		return result;
	}

	public Category get(int id) {
		NohCategory noh = search(id);
		if (noh != null)
			return noh.getInfo();
		return null;
	}

	public boolean contain(int id) {
		if (search(id) != null)
			return true;
		return false;
	}

	public int size() {
		int cont = 0;
		for (NohCategory i = start; i != null; i = i.getNext())
			cont++;
		return cont;
	}

	public void printStartToEnd() {
		for (NohCategory i = start; i != null; i = i.getNext())
			System.out.println(i.toString() + "\n");
	}

	public void printEndToStart() {
		for (NohCategory i = end; i != null; i = i.getPrev())
			System.out.println(i.toString() + "\n");
	}

	public boolean updateFileList(String archive) {
		try {
			LDE list = Archive.getLines(archive);
			Noh noh = list.getStart();
			do {
				// os dados devem vir do arquivo no formato: id;nome
				String line = (String) noh.getInfo();
				String data[] = line.split(";");
				if (data.length == 2) {
					insertEnd(new Category(Integer.parseInt(data[0]), data[1]));
				} else {
					System.out.println("Formato do arquivo de categorias inválido!");
					return false;
				}
				noh = noh.getNext();

			} while (noh != null);

		} catch (Exception e) {
			System.out.println("Erro ao ler Clientes:" + e.getMessage());
		}
		return true;
	}

	public boolean recordInFile(String archive) {
		String content = "id;nome\n";
		for (NohCategory i = start; i != null; i = i.getNext()) {
			Category category = i.getInfo();
			content += category.getID() + ";" + category.getName()+ "\n";
		}
		try {
			Archive.record(content, archive);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o arquivo das Categorias!");
			return false;
		}
		return true;
	}
}