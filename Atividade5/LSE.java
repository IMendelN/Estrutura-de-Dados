package Atividade5;

public class LSE implements Lista{
    
    private Noh inicio;
    private int totalNohs;

    public LSE(){
        this.inicio = null;
    }

    public void insereInicio(Object info){
        Noh novo = new Noh(info);
        if (inicio == null)
            inicio = novo;
        else {
            novo.setProx(inicio);
            inicio = novo;
        }
        totalNohs++;
    }

    public void insereFim(Object info) { 
        Noh novo = new Noh(info);
        if (inicio == null){
            inicio = novo;
        }else {
            Noh ultimo;
            for(Noh i=inicio; i != null; i=i.getProx()){
                ultimo = i;
                ultimo.setProx(novo);
            }
        }
        totalNohs++;
    }

    public int tamanho(){
        return this.totalNohs;
    }

    public boolean remove(Object info){
        Noh ant = null;
        Noh p = null;
        p = inicio;

        while (p != null && p.getInfo() != info){
            ant = p;
            p = p.getProx();
        }
        if (p == null){
            return false;
        }if (ant == null){
            inicio = p.getProx();
        }else{
            ant.setProx(p.getProx());
        }
        return true;
    }

    public boolean estahVazia(){
        if(inicio == null){
            return true;
        }
        return false;
    }

    public void imprime() {
    	for(Noh i = inicio; i != null; i = i.getProx()) {
            System.out.println(i.getInfo().toString());
    	}
    }
}
