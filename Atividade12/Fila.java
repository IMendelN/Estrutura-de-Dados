package Atividade12;
public class Fila implements IFila{
    private Noh inicio;
    private Noh fim;
    private int size;

    public Fila(){
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty(){
        if(inicio == null){
            return true;
        }
        return false;
    }

    public boolean add(Object info){

        Noh novo = new Noh(info);
        if(this.isEmpty()){
            inicio = novo;
            fim = inicio;
            size++;
        }else   {
            fim.setProx(novo);
            fim = novo;
            size++;
            return true;
        }
        return false;
    }

    public int size(){
        return this.size;
    }


    public boolean remove(){
        if(!this.isEmpty())
            if(inicio == fim){
                inicio = null;
                fim = null;
            }else {
                inicio = inicio.getProx();
                return true;
            }
            return false;
    }

    public void print(){
        for(Noh i = inicio; i != null; i = i.getProx()){
            System.out.println(i.getInfo().toString());
        }
    }
    
}