package Atividade16;

public class Noh {

    Noh esq;
    Noh dir;
    Noh pai;
    int info;

    Noh(int info) {
        this.esq = null;
        this.dir = null;
        this.pai = null;
        this.info = info;
    }

    public Noh getEsq() {
        return esq;
    }

    public void setEsq(Noh esq) {
        this.esq = esq;
    }

    public Noh getDir() {
        return dir;
    }

    public void setDir(Noh dir) {
        this.dir = dir;
    }

    public Noh getPai() {
        return pai;
    }

    public void setPai(Noh pai) {
        this.pai = pai;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

}