package lists.lde;

import baseClass.*;
import lists.nohs.Noh;
import lists.nohs.NohVehicle;

public class LDEVehicle {
	private NohVehicle start;
	private NohVehicle end;

	public LDEVehicle() {
		this.start = null;
		this.end = null;
	}

	public void insertStart(Vehicle info) {
		NohVehicle newest = new NohVehicle(info);
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

	public void insertEnd(Vehicle info) {
		NohVehicle newest = new NohVehicle(info);
		if (end == null) {
			start = newest;
			end = newest;
		} else {
			newest.setPrev(end);
			end.setNext(newest);
			end = newest;
		}
	}

	public boolean remove(Vehicle info) {
		NohVehicle p = search(info);
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

	public NohVehicle search(Vehicle info) {
		NohVehicle result = null;
		for (NohVehicle i = start; i != null; i = i.getNext()) {
			if (i.getInfo().getPlaque().equals(info.getPlaque()))
				return i;
		}
		return result;
	}

	public NohVehicle search(String plaque) {
		NohVehicle result = null;
		for (NohVehicle i = start; i != null; i = i.getNext()) {
			if (i.getInfo().getPlaque().equals(plaque))
				result = i;
		}
		return result;
	}

	public Vehicle get(String plaque) {
		NohVehicle noh = search(plaque);
		if (noh != null)
			return noh.getInfo();
		return null;
	}

	public boolean contain(String plaque) {
		if (search(plaque) != null)
			return true;
		return false;
	}

	public int size() {
		int cont = 0;
		for (NohVehicle i = start; i != null; i = i.getNext())
			cont++;
		return cont;
	}

	public void printStartToEnd() {
		for (NohVehicle i = start; i != null; i = i.getNext())
			System.out.println(i.toString() + "\n");
	}

	public void printEndToStart() {
		for (NohVehicle i = end; i != null; i = i.getPrev())
			System.out.println(i.toString() + "\n");
	}

	public boolean categoryIsLinked(int id) {
		for (NohVehicle i = start; i != null; i = i.getNext()) {
			if (i.getInfo().getCategory().getID() == id)
				return true;
		}
		return false;
	}

	public boolean updateFileList(String archive) {
		try {
			LDE list = Archive.getLines(archive);
			Noh noh = list.getStart();
			do {
				// os data devem vir do arquivo no formato:
				// plaque;modelo;marca;ano;potencia;lugares;categoria
				String line = (String) noh.getInfo();
				String data[] = line.split(";");
				if (data.length == 7) {
					Category category = OperacoesCategorias.getOperacoes().get(Integer.parseInt(data[6]));
					insertEnd(new Vehicle(data[0], data[1], data[2], Integer.parseInt(data[3]),
							Integer.parseInt(data[4]), Integer.parseInt(data[5]), category));
				} else {
					System.out.println("Formato do arquivo de veículos inválido!");
					return false;
				}
				noh = noh.getNext();

			} while (noh != null);

		} catch (Exception e) {
			System.out.println("Erro ao ler Veículos:" + e.getMessage());
		}
		return true;
	}

	public boolean recordInFile(String archive) {
		String content = "placa;modelo;marca;ano;potencia;lugares;categoria\n";
		for (NohVehicle i = start; i != null; i = i.getNext()) {
			Vehicle vehicle = i.getInfo();
			content += vehicle.getPlaque() + ";" + vehicle.getModel() + ";" + vehicle.getMark() + ";" + vehicle.getYear() + ";"
					+ vehicle.getPotency() + ";" + vehicle.getSeats() + ";" + vehicle.getCategory().getID() + "\n";
		}
		try {
			Archive.record(content, archive);
		} catch (Exception e) {
			System.out.println("Erro ao gravar o arquivo de Veículos!");
			return false;
		}
		return true;
	}
}