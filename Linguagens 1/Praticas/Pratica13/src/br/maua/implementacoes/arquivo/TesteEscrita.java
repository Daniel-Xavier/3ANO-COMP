import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TesteEscrita {
    public static void main(String[] args) {
        //Cria um arquivo
        File file = new File("nome.txt");
        try{


            //Cria uma conexão para escrever no arquivo
            FileWriter fileWriter = new FileWriter(file);
            //Cria um buffer de writting
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            //Escrever no arquivo
            bufferedWriter.write("Ola mundo arquivos!\n");
            bufferedWriter.write("LALALA!\n");
            bufferedWriter.write("2+2 = peixa ou " + 2 );
            //Força escrita na hora
            //bufferedWriter.flush();
            //Fechar o buffer e escreve no arquivo
            bufferedWriter.close();
            //Fecha os demais fluxos
            fileWriter.close();

        } catch (Exception exception){
            System.out.println("Algo deu errado");
            exception.printStackTrace();
        }
    }
}