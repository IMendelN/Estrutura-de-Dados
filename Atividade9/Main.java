package Atividade9;

import java.util.Random;

public class Main {
    public static void main(String args[]) {
        Random random = new Random();
        Vetor numerosDez = new Vetor();
        Vetor numerosCem = new Vetor();
        Vetor numerosMil = new Vetor();
        Vetor numerosDezMil = new Vetor();
        for (int i = 0; i < 10; i++) {
            int numero = random.nextInt(10);
            numerosDez.adiciona(numero);
        }
        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(100);
            numerosCem.adiciona(numero);
        }
        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt(1000);
            numerosMil.adiciona(numero);
        }
        for (int i = 0; i < 10000; i++) {
            int numero = random.nextInt(10000);
            numerosDezMil.adiciona(numero);
        }
        long tempoInicial = System.currentTimeMillis();
        long tempoFinal = System.currentTimeMillis();
        long tempo = tempoFinal - tempoInicial;
        System.out.println(numerosDezMil.tamanho());
        System.out.printf("Tempo de Execução: %.20f ms%n", (tempo) / 1000d);

    }
}