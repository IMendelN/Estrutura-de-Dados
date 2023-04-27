package baseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tenancy {
	private long cnh;
	private String plaque;
	private Date startDate;
	private Date endDate;
	private double value;

	public Tenancy(long cnh, String plaque, Date startDate, Date endDate, double value) {
		this.cnh = cnh;
		this.plaque = plaque;
		this.startDate = startDate;
		this.endDate = endDate;
		this.value = value;
	}

	public long getCNH() {
		return cnh;
	}

	public void setCNH(long cnh) {
		this.cnh = cnh;
	}

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String startD, endD;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		startD = format.format(startDate);
		if (endDate != null) {
			endD = format.format(endDate);
		} else
			endD = "n/a";

		return "Locacoes: \n CNH: " + cnh + "; \n Placa: " + plaque + "; \n Data de Inicio: " + startD
				+ "; \n Data do Fim: " + endD + "; \n Valor: " + value + ". \n";
	}

}