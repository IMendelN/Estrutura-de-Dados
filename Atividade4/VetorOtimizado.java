package Atividade4;

public class VetorOtimizado implements iVetor {
    private Object[] element = new Object[5];
    private int totalAlunos = 0;

    public int length() {
        return this.totalAlunos;
    }

    public void add(Object newElement) {
        garanteEspaco();
        this.element[this.totalAlunos] = newElement;
        this.totalAlunos++;
    }

    public boolean contem(Object newElement) {
        for (int i = 0; i < this.totalAlunos; i++) {
            if (newElement == this.element[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean cheio() {
        if (totalAlunos == this.element.length) {
            return true;
        }
        return false;
    }

    private void garanteEspaco() {
        if (this.cheio()) {
            Object[] newAlunos = new Object[this.element.length * 2];
            for (int i = 0; i < this.element.length; i++) {
                newAlunos[i] = this.element[i];
                this.element = newAlunos;
            }
        }
    }

    public boolean remove(Object newElement) {
        int indice = -1;

        for (int i = 0; i < totalAlunos; i++)
            if (newElement == this.element[i]) {
                indice = i;
                break;
            }
        if (indice != -1) {
            for (int i = indice; i < (element.length - 1); i++) {
                element[i] = element[i + 1];
            }
            totalAlunos--;
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < totalAlunos; i++) {
            System.out.print(element[i] + " ");
        }
    }

}
