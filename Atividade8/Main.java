package Atividade8;

public class Main {
    public static void main(String args[]) {
        Vetor numeros = new Vetor();
        for (int i = 0; i < 1000; i++) {
            numeros.adiciona(i);
        }
        long tempoInicialRec = System.currentTimeMillis();
        System.out.println(numeros.buscaBinRec(numeros.numeros, 0, numeros.tamanho() - 1, numeros.tamanho() - 1));
        long tempoFinalRec = System.currentTimeMillis();

        long tempoInicialInt = System.currentTimeMillis();
        System.out.println(numeros.buscaBinIter(numeros.tamanho() - 1));
        long tempoFinalInt = System.currentTimeMillis();

        long tempoRecursão = tempoFinalRec - tempoInicialRec;
        Long tempoIteração = tempoFinalInt - tempoInicialInt;
        System.out.printf("Tempo de Execução Recursivo: %.5f ms%n", (tempoRecursão) / 1000d);
        System.out.printf("Tempo de Execução Iterativo: %.5f ms%n", (tempoIteração) / 1000d);
    }
}