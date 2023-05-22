package Atividade9;

public class Vetor {
    public int numeros[] = new int[10000];
    private int totalNum = 0;

    public void adiciona(int num) {
        this.numeros[totalNum] = num;
        totalNum++;
    }

    public int tamanho() {
        return this.totalNum;
    }

    public void BubbleSort() {
        for (int i = 0; i < this.totalNum; i++) {
            for (int j = 0; j < this.totalNum - 1; j++) {
                if (this.numeros[j] > this.numeros[j + 1]) {
                    int aux = this.numeros[j];
                    this.numeros[j] = this.numeros[j + 1];
                    this.numeros[j + 1] = aux;
                }
            }
        }
    }

    public void SelectionSort() {
        for (int i = 0; i < this.totalNum; i++) {
            int menor = i;
            for (int j = i + 1; j < this.totalNum; j++) {
                if (this.numeros[j] < this.numeros[menor]) {
                    menor = j;
                }
            }
            int aux = numeros[i];
            this.numeros[i] = this.numeros[menor];
            this.numeros[menor] = aux;
        }
    }

    public void InsertionSort() {
        for (int i = 1; i < this.totalNum; i++) {
            int chave = this.numeros[i];
            int j = i - 1;
            while (j >= 0 && chave < this.numeros[j]) {
                this.numeros[j + 1] = this.numeros[j];
                j--;
            }
            this.numeros[j + 1] = chave;
        }
    }

    public void imprime() {
        for (int i = 0; i < this.totalNum; i++) {
            System.out.println(numeros[i]);
        }

    }
}