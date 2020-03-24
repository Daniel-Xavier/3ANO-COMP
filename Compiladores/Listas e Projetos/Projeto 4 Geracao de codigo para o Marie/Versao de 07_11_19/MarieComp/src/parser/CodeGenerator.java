package parser;
// Reflexive visitor pattern: https://www.cse.wustl.edu/~cytron/cacweb/Tutorial/Visitor/

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class CodeGenerator {

    private static final Stack<Identifier> idStack = new Stack();
    private static final HashMap<String, Integer> constTable = new HashMap();
    private static final StringBuffer code = new StringBuffer();
    private static final StringBuffer data = new StringBuffer();
    private static int idCount = 0;

    static public void generateAllCode() {
        // Gera a seção de código
        System.out.print(code.toString());
        // Gera a parada do programa
        System.out.println("HALT");
        // Gera a seção de dados a partir das tabelas
        Enumeration e = Parser.environment.keys();
        while (e.hasMoreElements()) {
            String id = (String) e.nextElement();
            data.append(id).append(", DEC 0").append("\n");
        }
        Set<String> consts = constTable.keySet();
        for (String c : consts) {
            Integer i = constTable.get(c);
            data.append(c).append(", DEC ").append(i).append("\n");
        }
        System.out.print(data.toString());
    }

    private Identifier generateID(Integer value) {
        // Cria e retorna um ID novo para variáveis temporárias
        Identifier id = new Identifier(String.format("TMP%010d", idCount++));
        // Armazena este ID em uma tabela de Hash para localizar seu valor
        constTable.put(id.getIdentifierName(), value);
        return id;
    }

    public void generateCode(Number number) {
        //Por causa do Marie, quando se encontra um número, gera-se
        //um identificador para ele
        Identifier tempID = generateID(number.getNumberValue());
        //Armazenar este ID na pilha para quando for gerado  o código do 
        // operador
        idStack.push(tempID);
    }

    public void generateCode(Identifier identifier) {
        // Apenas empilhar este identificador para uso posterior
        idStack.push(identifier);
    }

    public void generateCode(Operator operator) {
        // Em operadores unários ou binários, sempre haverá o elemento direito
        // Ao se desempilhar um elemento, ele corresponde ao lado direito
        Identifier right = idStack.pop();
        if (operator.getOperatorSymbol() == '@') {
            System.out.println("Gerar código do PRINT");
        } else {
            // Em operadores binários sempre se processa o identificador esquerdo
            // e direito
            Identifier left = idStack.pop();
            switch (operator.getOperatorSymbol()) {
                case '=':
                    code.append("LOAD ").append(right.getIdentifierName()).append("\n");
                    code.append("STORE ").append(left.getIdentifierName()).append("\n");
                    break;
                case '+':
                case '-':
                    Identifier tempID = generateID(0);

                    code.append("LOAD ").append(left.getIdentifierName()).append("\n");

                    if (operator.getOperatorSymbol() == '+') {
                        code.append("ADD ").append(right.getIdentifierName()).append("\n");
                    } else if (operator.getOperatorSymbol() == '-') {
                        code.append("SUBT ").append(right.getIdentifierName()).append("\n");
                    }

                    code.append("STORE ").append(tempID.getIdentifierName()).append("\n");
                    idStack.push(tempID);
                    break;
                default:
                    throw new Error("Operator not implemented!");
            }
        }
    }
}
