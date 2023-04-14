package Atividade5;

public class Noh{
    private Object info;
    private Noh prox;

    public Noh (Object info){
        this.info = info;
        this.prox = null;
    }

    

    /**
     * @return int return the info
     */
    public Object getInfo() {
        return info;
    }

    /**
     * @return Noh return the prox
     */
    public Noh getProx() {
        return prox;
    }

    /**
     * @param prox the prox to set
     */
    public void setProx(Noh prox) {
        this.prox = prox;
    }

    
}