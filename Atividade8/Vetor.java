package Atividade8;

public class Vetor {
    public int numeros[] = new int[1000];
    private int totalNum = 0;

    public void adiciona(int num) {
        this.numeros[totalNum] = num;
        totalNum++;
    }

    public int tamanho() {
        return this.totalNum;
    }

    public int buscaBinIter(int num) {
        int inicio = 0;
        int fim = this.totalNum;
        while (inicio < fim) {
            int meio = (inicio + fim) / 2;
            if (this.numeros[meio] == num) {
                return meio;
            } else if (this.numeros[meio] > num) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return -1;
    }

    public int buscaBinRec(int[] numeros, int inicio, int fim, int num) {
        int meio = (inicio + fim) / 2;
        if (numeros[meio] == num) {
            return numeros[meio];
        } else if (numeros[meio] > num) {
            int x = buscaBinRec(numeros, inicio, meio - 1, num);
            return x;
        } else {
            int x = buscaBinRec(numeros, meio + 1, fim, num);
            return x;
        }
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
}