package Atividade15;

public class ABB {
    private Noh raiz;

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void addRecursive(int info) {
        if (isEmpty()) {
            this.raiz = new Noh(info);
        } else {
            addRecursive(this.raiz, info);
        }
    }

    public void addRecursive(Noh raiz, int info) {
        if (info < raiz.info) {
            if (raiz.esq == null) {
                Noh newNoh = new Noh(info);
                raiz.esq = newNoh;
                newNoh.pai = raiz;
                return;

            }
            addRecursive(raiz.esq, info);
        } else {
            if (raiz.dir == null) {
                Noh newNoh = new Noh(info);
                raiz.dir = newNoh;
                newNoh.pai = raiz;
                return;
            }
            addRecursive(raiz.dir, info);
        }
    }

    public Noh buscaRecursiva(int info) {
        return buscaRecursiva(this.raiz, info);
    }

    public Noh buscaRecursiva(Noh raiz, int info) {
        if (raiz == null) {
            return null;
        } else if (info == raiz.info) {
            return raiz;
        } else if (info < raiz.info) {
            return buscaRecursiva(raiz.esq, info);
        } else {
            return buscaRecursiva(raiz.dir, info);
        }
    }

    public void imprime() {
        if (this.raiz == null) {
            return;
        } else {
            imprime(raiz.esq);
            System.out.println(raiz.getInfo() + "\n");
            imprime(raiz.dir);
        }
    }

    public void imprime(Noh raiz) {
        if (raiz == null) {
            return;
        } else {
            imprime(raiz.esq);
            System.out.println(raiz.getInfo() + "\n");
            imprime(raiz.dir);
        }
    }
}