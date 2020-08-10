package br.maua.arvore;

public class Arvoreu {

    //As funções/métodos pedidos no exercício estão definidas nessa classe

    public static void imprimeFilhos(No no){
        no.pegarFilhos().forEach(System.out::println);
    }

    public static No pai(No no){
        return no.pegarPai();
    }

    public static void imprimePai(No no){
        System.out.println(pai(no));
    }

    public static boolean ehInterno(No no){
        return !(no.pegarFilhos().isEmpty());
    }

    public static void imprimeFilhosFolhas(No no){
        no.pegarFilhos().forEach(filho->{
            if(!ehInterno(filho))System.out.println(filho);
        });
    }


    public static void dobraFilhos(No no ){
        no.pegarFilhos().forEach(filho->{
            filho.dado = filho.dado*2;
        });
    }

    public static void dobraPai(No no ){
        no.pegarPai().dado = no.pegarPai().dado*2;
    }

    public static void preorder(No no ){
        System.out.println(no);
        no.pegarFilhos().forEach(Arvoreu::preorder);
    }

    public static void posorder(No no ){
        imprimeFilhosFolhas(no);
        no.pegarFilhos().forEach(Arvoreu::posorder);
        if (ehInterno(no)) System.out.println(no);
    }
}
