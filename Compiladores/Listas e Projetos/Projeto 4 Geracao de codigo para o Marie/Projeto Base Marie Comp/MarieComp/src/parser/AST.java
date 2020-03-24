package parser;

public class AST {
    // Árvore AST esquerda
    private AST leftAST;
    // Árvore AST direita
    private AST rightAST;


    public AST(AST leftAST, AST rightAST) {
        this.leftAST = leftAST;
        this.rightAST = rightAST;
    }

    public AST getLeftAST() {
        return this.leftAST;
    }

    public AST getRightAST() {
        return this.rightAST;
    }
    
}
