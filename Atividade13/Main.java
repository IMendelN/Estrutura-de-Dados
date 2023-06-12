package Atividade13;

import java.util.Random;

public class Main {
    public static void main(String... args) {
        Random rand = new Random();
        VetorMap vetormap = new VetorMap();

        String[] string = { "Iago", "Maria", "Gabriela", "Marcelo" };
        int nome = rand.nextInt(string.length);

        Integer idade = Integer.valueOf(rand.nextInt(18));
        String matricula = String.valueOf(rand.nextLong(10000));
        for (int i = 0; i <= 10; i++) {
            vetormap.put(new Aluno(string[nome], idade, matricula));
        }

        vetormap.imprime();
    }
}