package Atividade6_1;

public class Main {
    public static void main(String[] args) {
        List l = new LDE();
        l.insertStart(200);
        l.insertEnd(2);
        System.out.println(l.isEmpty());
        System.out.println(l.size());
        l.printStartToEnd();
    }
}