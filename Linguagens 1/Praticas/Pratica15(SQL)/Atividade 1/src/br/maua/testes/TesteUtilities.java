package br.maua.testes;

import br.maua.utilities.IdGenerator;

public class TesteUtilities {
    public static void main(String[] args) {

        //System.out.println("" + LocalDateTime.now().getMonth().getValue());

        System.out.println("Valor Random:" + IdGenerator.generateId());
        System.out.println("Valor Random:" + IdGenerator.generateId());
        System.out.println("Valor Random:" + IdGenerator.generateId());

        System.out.println("Valor Formatado:" + IdGenerator.generateIdFormatado());
        System.out.println("Valor Formatado:" + IdGenerator.generateIdFormatado());
        System.out.println("Valor Formatado:" + IdGenerator.generateIdFormatado());
    }
}

