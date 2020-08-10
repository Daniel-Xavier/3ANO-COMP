package br.maua;

public class No {
    int codigo;     //dado
    String nome;    //dado
    int idade;      //dado
    No filhoEsquerda;  //filho à esquerda deste nó
    No filhoDireita;  //filho à direita deste nó

    public void mostraNo(){
        {
            System.out.print("{");
            System.out.print(codigo);
            System.out.print(", ");
            System.out.print(nome);
            System.out.print(", ");
            System.out.print(idade);
            System.out.print("} ");
        }
    }
}
