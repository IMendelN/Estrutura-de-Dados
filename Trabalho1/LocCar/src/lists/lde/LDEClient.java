package lists.lde;

import baseClass.*;
import lists.nohs.*;;

public class LDEClient {
	private NohClient start;
	private NohClient end;

	public LDEClient() {
		this.start = null;
		this.end = null;
	}

	public void insertStart(Client info) {
		NohClient newest = new NohClient(info);
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

	public void insertEnd(Client info) {
		NohClient newest = new NohClient(info);
		if (end == null) {
			start = newest;
			end = newest;
		} else {
			newest.setPrev(end);
			end.setNext(newest);
			end = newest;
		}
	}

	public boolean remove(Client info) {
		NohClient p = search(info);
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

	public NohClient search(Client info) {
		NohClient result = null;
		for (NohClient i = start; i != null ; i = i.getNext()) {
			if (i.getInfo().getCPF().equals(info.getCPF()))
				result = i;
		}
		return result;
	}

	public NohClient search(Long cpf) {
		NohClient result = null;
		for (NohClient i = start; i != null; i = i.getNext()) {
			if (i.getInfo().getCPF().equals(cpf))
				return i;
		}
		return result;
	}

	public Client get(Long cpf) {
		NohClient noh = search(cpf);
		if (noh != null)
			return noh.getInfo();
		return null;
	}

	public boolean contain(long cpf) {
		if (search(cpf) != null)
			return true;
		return false;
	}

	public int size() {
		int cont = 0;
		for (NohClient i = start; i != null; i = i.getNext())
			cont++;
		return cont;
	}

	public void printStartToEnd() {
		for (NohClient i = start; i != null; i = i.getNext())
			System.out.println(i.toString() + "\n");
	}

	public void printEndToStart() {
		for (NohClient i = end; i != null; i = i.getPrev())
			System.out.println(i.toString() + "\n");
	}

	public boolean updateFileList(String archive) {
		try {
			LDE list = Archive.getLines(archive);
			Noh noh = list.getStart();
			do {
				// os dados devem vir do arquivo no formato: nome;CPF;CNH;Telefone
				String line = (String) noh.getInfo();
				String data[] = line.split(";");
				if (data.length == 4) {
					insertEnd(new Client(data[0], Long.parseLong(data[2]), Long.parseLong(data[3]),
							Long.parseLong(data[1])));
				} else {
					System.out.println("Formato do arquivo de clientes inválido!");
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
		String content = "nome;CPF;CNH;Telefone\n";
		for (NohClient i = start; i != null; i = i.getNext()) {
			Client client = i.getInfo();
			content += client.getName() + ";" + client.getCPF() + ";" + client.getCNH() + ";" + client.getNumber() + "\n";
		}
		try {
			Archive.record(content, archive);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o arquivo de clientes!");
			return false;
		}
		return true;
	}

}