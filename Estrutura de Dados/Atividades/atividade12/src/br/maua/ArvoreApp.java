package br.maua;

public class ArvoreApp {
    public static void main(String[] args) {
		/*
		int codigo, idade, valor;
		String nome;
		*/
        Arvore aArvore = new Arvore();

        aArvore.insere(1, "\nMarcelo", 26);
        aArvore.insere(50, "\nJoao", 20);
        aArvore.insere(30, "Pedro", 28);
        aArvore.insere(4, "\nMaria", 24);
        aArvore.insere(25, "\nMiguel", 15);
        aArvore.insere(46, "\nPedroso", 11);
        aArvore.insere(7, "\nMirian", 45);

        aArvore.travessia(1);
        aArvore.in
    }
}