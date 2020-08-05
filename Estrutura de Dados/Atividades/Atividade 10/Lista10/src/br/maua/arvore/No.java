package br.maua.arvore;

import java.util.ArrayList;

public class No {

    public int dado; //Dado guardado no nó

    private No pai; //Pai

    private ArrayList<No> filhos = new ArrayList<>(); //Lista contendo os filhos

    //Construtor (define o dado)
    public No(int dado) {
        this.dado = dado;
    }

    //Getter para o pai
    public No pegarPai(){
        return this.pai;
    }

    //Getter p/ filhos
    public ArrayList<No> pegarFilhos() {
        return filhos;
    }

    //Adiciona um filho e define o pai do filho como esse nó
    protected void adicionarFilho(No filho){
        this.filhos.add(filho);
        filho.definirPai(this);
    }

    //Método privado, só é acessado pelo método adicionarFilho
    private void definirPai(No pai){
        this.pai = pai;
    }

    //Define a impressão do objeto nó como o dado guardado
    @Override
    public String toString() {
        return Integer.toString(dado);
    }

}
