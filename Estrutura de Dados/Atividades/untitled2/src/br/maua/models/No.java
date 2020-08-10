package br.maua.models;

import br.maua.enums.Lado;

public class No {
    public Integer valor;

    public No pai = null;
    public No esq = null;
    public No dir = null;

    public boolean nulo = true;
    public boolean isRaiz = false;
    public boolean hasEsq = false;
    public boolean hasDir = false;

    public No(Integer valor){
        // Construtor para a raiz
        this.valor = valor;
        isRaiz = true;
        nulo = valor == null;
    }

    public No (No pai, Integer valor, Lado lado) throws Exception {
        // Construtor para as sub-arvores
        if (pai.nulo) { throw new Exception("Pai nulo. Nao foi possivel adicionar o no a um pai vazio."); }

        this.valor = valor;
        this.pai = pai;

        if (lado == Lado.ESQ){
            pai.esq = this;
            pai.hasEsq = true;
        }
        else if (lado == Lado.DIR){
            pai.dir = this;
            pai.hasDir = true;
        }

        nulo = valor == null;
    }

    @Override
    public String toString() {
        String  str = "{\n";

        str += "    raiz : " + isRaiz + "\n     ";

        str += (isRaiz) ? "pai : nulo" : "pai : " + pai.valor;
        str += "\n   ";

        str += (valor == null) ? "valor : nulo" : "valor : " + valor;
        str += "\n     ";

        str += (esq != null) ? "esq : " + esq.valor : "esq : nulo";
        str += "\n     ";

        str += (dir != null) ? "dir : " + dir.valor : "dir : nulo";

        str += "\n}";

        return str;
    }
}