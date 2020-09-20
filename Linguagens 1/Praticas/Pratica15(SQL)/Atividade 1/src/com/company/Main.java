package com.company;

import com.company.model.Vendedor;

public class Main {

    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("1", "lala", "123456");
        System.out.println(vendedor);
        System.out.println("Senha:" + vendedor.getSenhaHash());
        System.out.println("Comparacao:" + vendedor.validate("qwert"));
        System.out.println("Comparacao:" + vendedor.validate("123456"));
//        AplicacaoDAO app = new AplicacaoDAO();
//        app.run();
    }
}