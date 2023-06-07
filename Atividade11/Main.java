package Atividade11;

public class Main {
    public static void main(String[] args) {
        IFila fila = new Fila(6);

        fila.add(new Aluno("Iago", 2110101225));
        fila.add(55);
        fila.add(8);
        fila.add(29);
        fila.add(30);
        fila.print();
    }
}