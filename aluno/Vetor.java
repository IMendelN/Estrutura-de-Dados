package aluno;

public class Vetor {
    private Aluno alunos[] = new Aluno[5];
    private int totalAlunos = 0;

    public void add(Aluno newAlunos) {
        this.alunos[this.totalAlunos] = newAlunos;
        this.totalAlunos++;

    }

    public int lenght() {
        return this.totalAlunos;

    }

    public boolean contem(Aluno newAlunos) {
        for (int i = 0; i < this.totalAlunos; i++) {
            if (newAlunos == this.alunos[i]) {
                return true;
            }
        }
        return false;
    }
}
