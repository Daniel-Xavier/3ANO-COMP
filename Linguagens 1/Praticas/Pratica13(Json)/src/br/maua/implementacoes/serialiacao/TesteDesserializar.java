package br.maua.implementacoes.serialiacao;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TesteDesserializar {
    public static void main(String[] args) {
        Pessoa p1, p2;

        try{
            //Acessa o arquivo
            FileInputStream fileInputStream = new FileInputStream("ecm251.maua");
            //Acesso os dados no arquivo
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //Ler os objetos no arquivo
            p1 = (Pessoa) objectInputStream.readObject();
            p2 = (Pessoa) objectInputStream.readObject();
            System.out.println("Objetos importados");

            System.out.println("Pessoas: "+ p1 + p2);
            //Fecha os fluxos
            objectInputStream.close();
            fileInputStream.close();

        } catch (Exception exception){
            System.out.println("Algo deu errado");
            exception.printStackTrace();
        }



    }
}