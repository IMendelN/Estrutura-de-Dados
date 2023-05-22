package Atividade6_2;

public interface List {
    public void insertStart(aluno info);

    public void insertEnd(aluno info);

    public boolean isEmpty();

    public boolean remove(String info);

    public Noh search(String info);

    public int size();

    public void printStartToEnd();

    public void printEndToStart();
}