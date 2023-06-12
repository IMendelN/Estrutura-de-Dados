package Atividade13;

public class VetorMap {

    private Aluno[] vetor = new Aluno[10];
    private int numElements;

    public int hash(String key) {
        return Integer.parseInt(key) % this.vetor.length;
    }

    public void put(Aluno value) {
        put(value.getMatricula(), value);
    }

    public void put(String key, Aluno value) {
        int hash;
        int sondagem = 0;
        while (sondagem < vetor.length) {
            hash = (hash(key) + sondagem) % vetor.length;
            if (vetor[hash] == null || vetor[hash].getMatricula() == key) {
                this.vetor[hash] = value;
                numElements++;
                reHash();
                return;
            }
            sondagem++;
        }
    }

    public boolean isEmpty() {
        if (numElements == 0) {
            return true;
        }
        return false;

    }

    public boolean reHash() {
        if (numElements / vetor.length > 0.7) {

        }
        return false;
    }

    public void reSize() {

        Aluno[] aux = vetor;
        Aluno[] novo = new Aluno[vetor.length * 2];
        this.vetor = novo;
        this.numElements = 0;
        for (Aluno Aluno : aux) {
            put(Aluno.getMatricula(), Aluno);
        }
    }

    public Aluno remove(String key) {
        if (isEmpty()) {
            return null;
        }
        int hash = hash(key);
        Aluno aluno = this.vetor[hash];
        this.vetor[hash(key)] = null;
        return aluno;

    }

    public Aluno get(String key) {
        int hash = hash(key);
        return this.vetor[hash];
    }

    public void imprime() {
        int aux = 0;
        for (int i = aux; i < vetor.length; i++) {
            if (vetor[i] != null) {
                aux++;
                System.out.println("Aluno " + i + ":" + vetor[i].toString());
            }
        }
    }
}