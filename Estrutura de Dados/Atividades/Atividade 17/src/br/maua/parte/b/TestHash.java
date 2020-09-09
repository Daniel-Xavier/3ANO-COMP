package br.maua.parte.b;

import java.util.LinkedList;

public class TestHash {
    public static void main(String[] args) {
        SList[] tabKeys = new SList[20];

            tabKeys[0]  = new SList(0);
            tabKeys[1]  = new SList(1);
            tabKeys[2]  = new SList(2);
            tabKeys[3]  = new SList(3);
            tabKeys[4]  = new SList(4);
            tabKeys[5]  = new SList(5);
            tabKeys[6]  = new SList(6);
            tabKeys[7]  = new SList(7);
            tabKeys[8]  = new SList(8);
            tabKeys[9]  = new SList(9);
            tabKeys[10] = new SList(10);
            tabKeys[11] = new SList(11);
            tabKeys[12] = new SList(12);
            tabKeys[13] = new SList(13);
            tabKeys[14] = new SList(14);
            tabKeys[15] = new SList(15);
            tabKeys[16] = new SList(16);
            tabKeys[17] = new SList(17);
            tabKeys[18] = new SList(18);
            tabKeys[19] = new SList(19);

        LinkedList <Integer> ListaLigada = new LinkedList<Integer>();


        Integer hashCode = null, chave;
        SList[] tabHash = new SList[10];
        for (int i=0; i<tabKeys.length; i++ ) {
            chave = (tabKeys[i].getKey());
            hashCode = hash(chave);
            System.out.println("Chave = " + chave +
                    " mapeada para hascode = " + hashCode);
            if (tabHash[hashCode] == null )
                tabHash[hashCode] = tabKeys[i];
            else {
                System.out.println("** Colisao no slot da Tabela Hash ** " );
                System.out.println("Chave " + tabKeys[i].getKey() +
                        " NAO ARMAZENADA NA TABELA HASH ...\n " ) ;
            }
        }
        System.out.println("\nTabela Aluno: ");
        System.out.println("--------------------------");
        for (int i = 0 ; i < tabKeys.length; i++)
            System.out.print ("Slot " + i + " ---> " + tabKeys[i].getKey() + "\n" );
        System.out.println("\nTabela HASH: ");
        System.out.println("--------------------------");
        for (int i = 0 ; i < tabHash.length; i++)
            if (tabHash[i] == null)
                System.out.println("Slot " + i + " ---> Valor nulo");

    }
    public static Integer hash(Integer key) {
        return (key % 10);

    }

}
