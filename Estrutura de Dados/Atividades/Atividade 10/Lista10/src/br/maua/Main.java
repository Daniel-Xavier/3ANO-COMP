package br.maua;

import br.maua.arvore.Arvore;
import br.maua.arvore.Arvoreu;
import br.maua.arvore.No;

public class Main {

    /*
    Grupo
    Bruna G.Guede - 18.00189-0
    Daniel U. Xavier - 18.00022-3
    Rodolfo C. Bezerra - 18.00202-0
    Vitor M. Simoni - 18.00050-9
    Leonardo Cury Haddad - 18.00442-3
    Leonardo de Barros Rodrigues - 18.02401-7
     */

    public static void main(String[] args) {

        //Cria os nós da árvore do exercicio
        No no5 = new No(5);
        No no0 = new No(0);
        No no1 = new No(1);
        No no2 = new No(2);
        No no3 = new No(3);
        No no4 = new No(4);
        No no6 = new No(6);
        No no7 = new No(7);
        No no8 = new No(8);
        No no21 = new No(21);

        //Cria a árvore
        Arvore arvore = new Arvore(no5);

        //Monta a árvore
        arvore.adicionarNo(no5,no4);
        arvore.adicionarNo(no5,no3);
        arvore.adicionarNo(no5,no7);
        arvore.adicionarNo(no4,no1);
        arvore.adicionarNo(no4,no2);
        arvore.adicionarNo(no3,no8);
        arvore.adicionarNo(no7,no0);
        arvore.adicionarNo(no7,no6);
        arvore.adicionarNo(no8,no21);
       // arvore.adicionarNo(no8,no12);

        //Roda alguns dos métodos
        System.out.println("---- Preorder ----");
        Arvoreu.preorder(no5);
        System.out.println("---- Posorder ----");
        Arvoreu.posorder(no5);

        System.out.println("---------------------");
        System.out.println("---- Filhos do 5 ----");
        Arvoreu.imprimeFilhos(no5);
        System.out.println("---- Pai do 8 ----");
        Arvoreu.imprimePai(no8);

        Arvoreu.dobraFilhos(no5);
        System.out.println("---- Filhos do 8 dobrados ----");
        System.out.println("-------   Filhos do 8   ------");
        Arvoreu.imprimeFilhos(no5);

        Arvoreu.dobraPai(no2);
        System.out.println("---- Pai do 2 dobrado ----");
        System.out.println("------   Pai do 2   ------");
        Arvoreu.imprimePai(no2);
        System.out.println("*Repare que o valor já havia sido dobrado anteriormente");

    }
}
