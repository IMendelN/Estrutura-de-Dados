package Atividade16;

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

    public Noh remove(int info) {
        Noh current = this.raiz;
        Noh pai = null;
        while (current != null && current.info != info) {
            pai = current;
            if (info < raiz.info) {
                current = current.esq;
            } else {
                current = current.dir;
            }
        }
        if (current == null) {

            return this.raiz;

        } else if (current.esq == null && current.dir == null) {

            if (current != raiz) {

                if (pai.esq == current) {

                    pai.esq = null;

                } else {
                    pai.dir = null;
                }
            } else {
                raiz = null;
            }
        } else if (current.esq != null && current.dir != null) {
            Noh sucessor = getMinimumNoh(current.dir);

            int inf = sucessor.info;

            remove(sucessor.info);

            current.info = inf;
        } else {
            Noh child = (current.esq != null) ? current.esq : current.dir;

            if (current != raiz) {
                if (current == pai.esq) {
                    pai.esq = child;
                } else {
                    pai.dir = child;
                }
            } else {
                raiz = child;
            }
        }
        return raiz;
    }

    public static Noh getMinimumNoh(Noh raiz) {
        while (raiz.esq != null) {
            raiz = raiz.esq;
        }
        return raiz;
    }

    public static Noh MaiorValor(Noh raiz) {
        while (raiz.dir != null) {
            raiz = raiz.dir;
        }
        return raiz;
    }
}