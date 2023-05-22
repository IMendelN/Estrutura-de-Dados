package Atividade7;

public class Vetor {
    public int numeros[] = new int[1001];
    private int totalNum = 0;

    public void adiciona(int num) {
        this.numeros[totalNum] = num;
        totalNum++;
    }

    public int tamanho() {
        return this.totalNum;
    }

    public int maximoRec(int[] numeros, int inicio, int fim) {
        if (inicio == fim) {
            return numeros[inicio];
        } else {
            int meio = (inicio + fim) / 2;
            int max1 = maximoRec(numeros, inicio, meio);
            int max2 = maximoRec(numeros, meio + 1, fim);
            if (max1 > max2) {
                return max1;
            } else {
                return max2;
            }
        }
    }

    public int maximoInt() {
        int maiorValor = 0;
        for (int i = 0; i < this.totalNum; i++) {
            if (this.numeros[i] > maiorValor) {
                maiorValor = this.numeros[i];
            }
        }
        return maiorValor;
    }
}