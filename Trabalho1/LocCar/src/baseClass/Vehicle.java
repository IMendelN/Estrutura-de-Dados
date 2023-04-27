package baseClass;

public class Vehicle {
    private String plaque;
    private String model, mark;
    private int year, potency, seats;
    private Category category;

    public Vehicle(String plaque, String model, String mark, int year, int potency, int seats, Category category) {
        this.plaque = plaque;
        this.model = model;
        this.mark = mark;
        this.year = year;
        this.potency = potency;
        this.seats = seats;
        this.category = category;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPotency() {
        return potency;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (category != null) {
            return "Veiculos: \n Placa: " + plaque + "; \n Modelo: " + model + "; \n Marca: " + mark + "; \n Ano: "
                    + year + "; \n Potencia: "
                    + potency + "; \n Numero de lugares: " + seats + "; \n Categoria: " + category.getName() + ". \n";
        } else
            return "Veiculos: \n Placa: " + plaque + "; \n Modelo: " + model + "; \n Marca: " + mark + "; \n Ano: "
                    + year + "; \n Potencia: "
                    + potency + "; \n Numero de lugares: " + seats + "; \n Categoria: " + "Desconhecida" + ". \n";

    }

}