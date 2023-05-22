package Atividade6_2;
public class LDE implements List{
    
    private Noh start;
    private Noh end;
    private int totalNohs;

    public LDE(){
        this.start = null;
        this.end = null;
    }

    public void insertStart(aluno a){
        Noh newest = new Noh(a);
        if (start == null){
            start = newest;
            end = newest;
        }else {
            newest.setNext(start);
            start.setPrev(newest);
            start = newest;
        }
        totalNohs++;
    }

    public void insertEnd(aluno a) { 
        Noh novo = new Noh(a);
        if (end == null){
            start = novo;
            end = novo;
        } else {
            novo.setPrev(end);
            end.setNext(novo);
            end = novo;
        }
    }

    public int size(){
        return this.totalNohs;
    }

    
	public Noh search(String a) {
		Noh retNoh = null;
		for(Noh i = start; i != null; i = i.getNext()){
            if(i.getInfo().getNome().equals(a)){
                retNoh = i;
            }
        }
		return retNoh;
	}


    public boolean remove(String a){
        Noh p = search(a);
        if (p == null){
            return false;
        }if (p.getPrev() == null){
            start = p.getNext();
            if(start != null)
                start.setPrev(null);
        }else if (p.getNext() == null){ //info estah no fim
            p.getPrev().setNext(null);
            end = p.getPrev();
        } else { //info estah no meio
            p.getPrev().setNext(p.getNext());
            p.getNext().setPrev(p.getPrev());
        }
        return true;
    }

    public boolean isEmpty(){
        if(start == null){
            return true;
        }
        return false;
    }

    public void printStartToEnd() {
    	for(Noh i = start; i != null; i = i.getNext()) {
            System.out.println(i.getInfo());
    	}
    }

    public void printEndToStart(){
        for(Noh i = end; i != null; i = i.getPrev()){
            System.out.println(i.getInfo());
        }
    }
}