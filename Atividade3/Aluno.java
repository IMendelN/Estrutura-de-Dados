package Atividade3;

public class Aluno {
    private String name;
    private int idade;
    private double notas;

    public Aluno(String name, int idade, double notas) {
        this.name = name;
        this.idade = idade;
        this.notas = notas;
    }

    public String getName() {
        return name;
    }

    public int getIdade() {
        return idade;
    }

    public double getNotas() {
        return notas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }

}
