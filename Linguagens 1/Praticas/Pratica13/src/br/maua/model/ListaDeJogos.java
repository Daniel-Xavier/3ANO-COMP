package br.maua.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeJogos {
    private List<Jogo> minhaListadeJogos;

    public ListaDeJogos() {
        this.minhaListadeJogos = new ArrayList<>();
    }

    public void addJogo(Jogo jogo){
        this.minhaListadeJogos.add(jogo);
    }

    @Override
    public String toString() {
        return "ListadeJogos{" +
                "minhaListadeJogos=" + minhaListadeJogos +
                '}';
    }
}
