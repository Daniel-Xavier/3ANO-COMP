package br.maua;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree arv = new Tree();
        int opcao;
        long x;
        int d, e;
        System.out.print("\n Programa Arvore binaria de long");
        do {
            System.out.print("\n***********************************");
            System.out.print("\nEntre com a opcao:");
            System.out.print("\n -1: Inserir");
            System.out.print("\n -2: Excluir");
            System.out.print("\n -3: Pesquisar");
            System.out.print("\n -4: Exibir");
            System.out.print("\n -5: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\n-> ");
            opcao = scanner.nextInt();
            switch(opcao) {
                case 1: {
                    System.out.print("\n Informe o valor do no e seus filhos (d,e) ");
                    x = scanner.nextLong();
                    d = scanner.nextInt();
                    e = scanner.nextInt();
                    arv.inserir(x,d,e);
                    break;
                }
                case 2: {
                    System.out.print("\n Informe o valor (long) -> ");
                    x = scanner.nextLong();
                    if ( !arv.remover(x) )
                        System.out.print("\n Valor nao encontrado!");
                    break;
                }
                case 3: {
                    System.out.print("\n Informe o valor (long) -> ");
                    x = scanner.nextLong();
                    if( arv.buscar(x) != null )
                        System.out.print("\n Valor Encontrado");
                    else
                        System.out.print("\n Valor nao encontrado!");
                    break;
                }
                case 4: {
                    arv.caminhar();
                    break;
                }
            } // fim switch
        } while(opcao != 5);

    }



}
