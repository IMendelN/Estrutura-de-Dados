package Atividade15;

public class Main {
    public static void main(String[] args) {
        ABB arv = new ABB();
        arv.addRecursive(5);
        arv.addRecursive(10);
        arv.addRecursive(11);
        arv.addRecursive(12);
        arv.imprime();
        arv.buscaRecursiva(5);
    }
}