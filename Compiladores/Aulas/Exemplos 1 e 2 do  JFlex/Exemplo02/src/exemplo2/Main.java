package exemplo2;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso : java -jar <arquivo>");
        }
        else {
            Lexer scanner = null;
            try {
                java.io.FileInputStream stream = new java.io.FileInputStream(args[0]);
                java.io.Reader reader = new java.io.InputStreamReader(stream);
                scanner = new Lexer(reader);
                Token token = scanner.yylex(); 
                while ( token.tag != Tag.EOF ){
                    if (token instanceof Word) {
						System.out.println(((Word)token).lexeme);
					}
                    token = scanner.yylex();
                }
            }
            catch (java.io.FileNotFoundException e) {
                        System.out.println("Arquivo não encontrado : \""+args[0]+"\"");
                }
                catch (java.io.IOException e) {
                        System.out.println("Erro de E/S durante a varredura : \""+args[0]+"\"");
                        System.out.println(e);
                }
                catch (Exception e) {
                        System.out.println("Exceção não esperada:");
                        e.printStackTrace();
                }
        }
    }
}
