package Atividade7;

import java.util.Random;

public class Main {
    public static void main(String args[]) {
        Vetor numeros = new Vetor();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt(10000);
            numeros.adiciona(numero);
        }
        long tempoInicialRec = System.currentTimeMillis();
        System.out.println("Método Recursivo:" + numeros.maximoRec(numeros.numeros, 0, numeros.tamanho()));
        long tempoFinalRec = System.currentTimeMillis();

        long tempoInicialInt = System.currentTimeMillis();
        System.out.println("Método Iterativo:" + numeros.maximoInt());
        long tempoFinalInt = System.currentTimeMillis();
        long tempoRecursão = tempoFinalRec - tempoInicialRec;
        Long tempoIteração = tempoFinalInt - tempoInicialInt;
        System.out.printf("Tempo de Execução Recursivo: %.5f ms%n", (tempoRecursão) / 1000d);
        System.out.printf("Tempo de Execução Iterativo: %.5f ms%n", (tempoIteração) / 1000d);

    }
}