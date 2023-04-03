package Atividade3;

public class Main {
    public static void main(String[] args) {
        Vetor vetAluno = new Vetor();
        Aluno a1 = new Aluno("Marcos", 17, 10.0);
        Aluno a2 = new Aluno("João", 19, 8.5);
        Aluno a3 = new Aluno("Sara", 21, 5.5);

        vetAluno.add(a1);
        vetAluno.add(a2);
        vetAluno.add(a3);

        System.out.println(vetAluno.contem(a3));
        System.out.println(vetAluno.lenght());

    }
}
