package Atividade6_2;

public class Main {
    public static void main(String[] args) {
        List l = new LDE();
        aluno newAluno = new aluno("Iago", 23, 8.5);
        l.insertStart(newAluno);
        l.insertEnd(new aluno("Sara", 17, 6.2));
        l.search("Sara");
        System.out.println(l.isEmpty());
        System.out.println(l.size());
        l.insertEnd(new aluno("Maria", 18, 6.0));
        l.printEndToStart();
        System.out.println(l.size());
        l.remove("Sara");
        l.printStartToEnd();
    }
}