package parser;

public class Identifier extends AST implements CodeItem {

    private final String identifier;

    public Identifier(String identifier) {
        // Inicializa a parte básica do AST com null
        super(null, null);
        this.identifier = identifier;
    }

    public String getIdentifierName() {
        return this.identifier;
    }

    @Override
    public String toString() {
        return "Identifier: " + this.getIdentifierName();
    }

    @Override
    public void generateCodeItem(CodeGenerator codeGenerator) {
        codeGenerator.generateCode(this);
    }

}
