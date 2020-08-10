package br.maua.models;

import java.util.ArrayList;
import java.util.List;

public class Arvore {
    private No raiz;
    private final List<No> nos = new ArrayList<>();

    public Arvore(No raiz) {
        // Criando raiz vazia
        this.raiz = raiz;
        nos.add(raiz);
    }

    public void inserirNo(No noNovo){
        nos.add(noNovo);
    }

    public No getNoPorIndice(int indice){
        return nos.get(indice);
    }

    public No getNoPorValor(Integer valor){
        for (int i = 0; i < nos.size(); i++) {
            if (nos.get(i).valor == valor) { return nos.get(i); }
        }
        return null;
    }

    public List<Integer> preOrder(){
        List<Integer> lista = new ArrayList<>();
        pre(raiz, lista);
        return lista;
    }
    private List<Integer> pre(No no, List<Integer> lista){
        lista.add(no.valor);

        if (no.hasEsq) { pre(no.esq, lista); }

        if (no.hasDir) { pre(no.dir, lista); }

        return lista;
    }

    public List<Integer> inOrder(){ // Esq, Raiz, Dir
        List<Integer> lista = new ArrayList<>();
        in(raiz, lista);
        return lista;
    }
    private List<Integer> in(No no, List<Integer> lista){
        if (no.hasEsq) { in(no.esq, lista); }

        lista.add(no.valor);

        if (no.hasDir) { in(no.dir, lista); }

        return lista;
    }

    public List<Integer> posOrder(){ // Esq, Raiz, Dir
        List<Integer> lista = new ArrayList<>();
        pos(raiz, lista);
        return lista;
    }
    private List<Integer> pos(No no, List<Integer> lista){
        if (no.hasEsq) { pos(no.esq, lista); }

        if (no.hasDir) { pos(no.dir, lista); }

        lista.add(no.valor);

        return lista;
    }

    @Override
    public String toString(){
        String str = "[ ";

        for (int i = 0; i < nos.size(); i++) {
            str += nos.get(i).valor;
            str += " ; ";
        }

        str = str.substring(0, str.length() - 3);
        str += " ]";

        return str;
    }
}