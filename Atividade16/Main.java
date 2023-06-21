package Atividade16;

public class Main {
    public static void main(String[] args) {
        ABB arv = new ABB();
        arv.addRecursive(5);
        arv.addRecursive(10);
        arv.addRecursive(11);
        arv.addRecursive(12);
        arv.imprime();
        System.out.println(arv.buscaRecursiva(5));
        arv.remove(12);
        arv.imprime();
    }
}