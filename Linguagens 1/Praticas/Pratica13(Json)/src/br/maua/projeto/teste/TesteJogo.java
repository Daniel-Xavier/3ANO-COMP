package br.maua.projeto.teste;

import br.maua.projeto.model.Jogo;

public class TesteJogo {
    public static void main(String[] args) {
        Jogo jogo = new Jogo("Computador","Diablo 3");
        System.out.println("Jogo:" +jogo);
        jogo.setStatusJogando();
        System.out.println("Jogo:" +jogo);

    }
}
