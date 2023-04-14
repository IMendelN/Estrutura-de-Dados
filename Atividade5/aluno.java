package Atividade5;

public class aluno{

    private String nome;
    private int idade;
    private double nota;

    
    public aluno(String nome, int idade, double nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "aluno [idade=" + idade + ", nome=" + nome + ", nota=" + nota + "]";
    }
    
    
    
}