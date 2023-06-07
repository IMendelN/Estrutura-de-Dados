package Atividade12;

public class Main {
    public static void main(String... args) {
        IFila fila = new Fila();

        fila.add(new Aluno("Iago", 2110101225));
        fila.add(new Aluno("Gabriela", 2110202240));
        fila.add(new Aluno("João", 2034556080));
        fila.remove();
        System.out.println(fila.isEmpty());
        System.out.println(fila.size());
        fila.print();
    }
}