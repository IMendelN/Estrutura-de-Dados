package Atividade5;

public class Main {
    public static void main(String[] args) {
        Lista l = new LSE();
        aluno newaluno = new aluno("Iago",22, 7.2);
        aluno newaluno2 = new aluno("Gabriela", 20, 6.5);
        l.insereInicio(newaluno);
        l.insereInicio(newaluno2);
        System.out.println(l.estahVazia());
        l.imprime();
    }
}