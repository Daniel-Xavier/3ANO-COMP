package br.maua;

import br.maua.enums.Lado;
import br.maua.interfaces.Menu;
import br.maua.models.Arvore;
import br.maua.models.No;

public class App implements Menu {
    public static void main(String[] args) throws Exception {
        // Iniciando arvore
        System.out.println("--------------------");
        System.out.println("Iniciando arvore com raiz nao nula");
        Arvore arv = new Arvore(new No(0));
        System.out.println(arv);

        // Inserindo filhos
        System.out.println("--------------------");
        System.out.println("Inserindo nos");
        arv.inserirNo(new No(arv.getNoPorIndice(0), 1, Lado.ESQ)); // 1
        arv.inserirNo(new No(arv.getNoPorIndice(0), 2, Lado.DIR)); // 2
        arv.inserirNo(new No(arv.getNoPorIndice(2), 3, Lado.ESQ)); // 3
        arv.inserirNo(new No(arv.getNoPorIndice(2), 4, Lado.DIR)); // 4
        arv.inserirNo(new No(arv.getNoPorIndice(3), 5, Lado.ESQ)); // 5
        arv.inserirNo(new No(arv.getNoPorIndice(3), 6, Lado.DIR)); // 6
        System.out.println(arv);

        // Percorrendo arvore
        System.out.println("--------------------");
        System.out.println("Percorrendo arvore");

        // Pre Order
        System.out.println("  preOrder : " + arv.preOrder());

        // In Order
        System.out.println("   inOrder : " + arv.inOrder());

        // Pos Order
        System.out.println("  posOrder : " + arv.posOrder());
    }
}