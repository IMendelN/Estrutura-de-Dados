package baseClass;

public class Client {
	private String name;
	private Long cnh, number, cpf;

	public Client(String name, Long cnh, Long number, Long cpf) {
		this.name = name;
		this.cnh = cnh;
		this.number = number;
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCNH() {
		return cnh;
	}

	public void setCNH(Long cnh) {
		this.cnh = cnh;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getCPF() {
		return cpf;
	}

	public void setCPF(Long cpf) {
		this.cpf = cpf;
	}

	public String toString() {
        return "Cliente: \n Nome: " + name + "; \n CNH: " + cnh + "; \n Numero de Telefone: " + number + "; \n CPF: " + cpf + ". \n";
    }

}