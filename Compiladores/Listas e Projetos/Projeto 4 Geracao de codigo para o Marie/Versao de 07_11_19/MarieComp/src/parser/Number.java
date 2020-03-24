package parser;

public class Number extends AST implements CodeItem {
    // Número inteiro do operando
    private final Integer value;

    public Number(Integer value) {
        // Inicializa a parte básica do AST com null
        super(null, null);
        this.value = value;
    }

    public Integer getNumberValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Number " + this.getNumberValue().toString();
    }

    @Override
    public void generateCodeItem(CodeGenerator codeGenerator) {
        codeGenerator.generateCode(this);
    }
}
