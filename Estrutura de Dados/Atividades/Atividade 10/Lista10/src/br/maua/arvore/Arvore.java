package br.maua.arvore;

public class Arvore {

    /*
    A classe Arvore força uma raiz
     */

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    private No raiz; //Raiz da arvore

    public void adicionarNo(No pai, No filho){
        pai.adicionarFilho(filho);
    }

}
