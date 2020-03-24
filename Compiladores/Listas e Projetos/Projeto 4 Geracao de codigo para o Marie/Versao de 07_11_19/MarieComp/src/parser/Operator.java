package parser;

public class Operator extends AST implements CodeItem {

    // Símbolo do operador
    private final char operator;

    public Operator(char op, AST leftAST, AST rightAST) {
        // Inicializa a parte básica do AST
        super(leftAST, rightAST);
        this.operator = op;
    }

    public char getOperatorSymbol() {
        return this.operator;
    }

    @Override
    public String toString() {
        return "Operator: " + this.getOperatorSymbol();
    }

    @Override
    public void generateCodeItem(CodeGenerator codeGenerator) {
        if (this.getLeftAST() != null) {
            ((CodeItem) this.getLeftAST()).generateCodeItem(codeGenerator);
        }
        if (this.getRightAST() != null) {
            ((CodeItem) this.getRightAST()).generateCodeItem(codeGenerator);
        }
        codeGenerator.generateCode(this);
    }
}
