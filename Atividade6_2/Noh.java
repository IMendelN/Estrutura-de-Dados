package Atividade6_2;

public class Noh {
	private aluno info;
	private Noh prox;
	private Noh ant;

	public Noh(aluno info) {
		this.info = info;
		this.prox = null;
		this.ant = null;
	}

	/**
	 * @return int return the info
	 */
	public aluno getInfo() {
		return info;
	}

	/**
	 * @return Noh return the prox
	 */
	public Noh getNext() {
		return prox;
	}

	/**
	 * @param prox the prox to set
	 */
	public void setNext(Noh prox) {
		this.prox = prox;
	}

	public Noh getPrev() {
		return ant;
	}

	public void setPrev(Noh ant) {
		this.ant = ant;
	}

}