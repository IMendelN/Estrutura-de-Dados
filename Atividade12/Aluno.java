package Atividade12;

public class Aluno {
    private long matricula;
    private String nome;

    public Aluno(String nome, long matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ".\nMatricula: " + matricula + ".\n";
    }

}