package br.maua;

import java.util.Stack;

public class Arvore {
    private No raiz; // o único campo de dado em Arvore

    public Arvore() { // construtor
        raiz = null;  //nenhum nó na arvore
    }
    /*
     * O método pesquisa busaca na arvore um nó com base
     * na chave que lhe é passado pelo parâmetro chave
     */
    public No pesquisa(int chave)
    { // assume-se que a árvore não está vazia
        No atual = raiz; // começa na raiz
        while (atual.codigo != chave) // enquanto não coincide,
        {
            if (chave < atual.codigo) // ir para esquerda?
                atual = atual.filhoEsquerda;
            else
                // ou ir para direita?
                atual = atual.filhoDireita;
            if (atual == null) // se não há filhos,
                return null; // não o encontrou
        }
        return atual; // encontrou-o
    } // fim do método pesquisa
    /*
     * O método insere insere um nó na arvore, recebendo como parâmetro
     * os dados do nó
     */
    public void insere(int Nno, String nome, int idade) {
        No novoNo = new No(); // cria novo nó
        novoNo.codigo = Nno; // insere dados no nó
        novoNo.nome = nome;
        novoNo.idade = idade;
        if (raiz == null) // sem nó na raiz
            raiz = novoNo;
        else // raiz ocupada
        {
            No atual = raiz; // começa na raiz
            No parente;
            while (true) // (sai internamente)
            {
                parente = atual;
                if (Nno < atual.codigo) // vai para esquerda?
                {
                    atual = atual.filhoEsquerda;
                    if (atual == null) // se fim da linha,
                    { // insere a esquerda
                        parente.filhoEsquerda = novoNo;
                        return;
                    }
                }
                else // ou vai para direita?
                {
                    atual = atual.filhoDireita;
                    if (atual == null) // if end of the line
                    { // insert on right
                        parente.filhoDireita = novoNo;
                        return;
                    }
                } // fim do else ir para direita
            } // fim do while
        } // fim do else não raiz
    } // fim do método insere

    /*
     * O método delete apaga um nó da árvore passado como
     * parâmetro pela variável chave
     */
    public boolean delete(int chave)
    { // assume arvore não vazia
        No atual = raiz;
        No parente = raiz;
        boolean eFilhoEsquerda = true;

        while (atual.codigo != chave) // busca nó
        {
            parente = atual;
            if (chave < atual.codigo) // vai para esquerda?
            {
                eFilhoEsquerda = true;
                atual = atual.filhoEsquerda;
            } else // ou para direita?
            {
                eFilhoEsquerda = false;
                atual = atual.filhoDireita;
            }
            if (atual == null) // fim da linha
                return false; // não o encontrou
        } // fim do while
        // encontrou nó para eliminar

        // se não há filho, simplesmente elimina-o
        if (atual.filhoEsquerda == null && atual.filhoDireita == null) {
            if (atual == raiz) // se raiz,
                raiz = null; // a árvore está vazia
            else if (eFilhoEsquerda)
                parente.filhoEsquerda = null; // desconecta
            else
                // from parent
                parente.filhoDireita = null;
        }

        // se não há filho à direita, substitui por subárvore à esquerda
        else if (atual.filhoDireita == null)
            if (atual == raiz)
                raiz = atual.filhoDireita;
            else if (eFilhoEsquerda)		// filho a esquerda do pai
                parente.filhoDireita = atual.filhoEsquerda;
            else							// filho a direita do pai
                parente.filhoDireita = atual.filhoDireita;

            // se não há filho à esquerda, substitui por subárvore à direita
        else if (atual.filhoEsquerda == null)
            if (atual == raiz)
                raiz = atual.filhoDireita;
            else if (eFilhoEsquerda)		// filho a esquerda do pai
                parente.filhoEsquerda = atual.filhoDireita;
            else							// filho a direita do pai
                parente.filhoDireita = atual.filhoDireita;

        else // dois filhos, assim substitua-o com o sucessor inorder
        {
            // pega o sucessor do No para deletar o atual
            No successor = getSuccessor(atual);

            // connecta parente do atual ao successor
            if (atual == raiz)
                raiz = successor;
            else if (eFilhoEsquerda)
                parente.filhoEsquerda = successor;
            else
                parente.filhoDireita = successor;

            // conecte sucessor ao filho à esquerda do atual
            successor.filhoDireita = atual.filhoDireita;
        } // fim do else dois filhos
        // (sucessor não pode ter filho à esquerda)
        return true; // sucesso
    } // fim do método delete()
    // -------------------------------------------------------------

    // retorna nó com próximo valor mais alto depois de deleteNo
    // vai para filho à direita, então para descendentes à esquerda
    private No getSuccessor(No deleteNo) {
        No sucessorParente = deleteNo;
        No sucessor = deleteNo;
        No atual = deleteNo.filhoDireita; // vai para filho à direita
        while (atual != null){ // até não mais filhos a esquerda
            sucessorParente = sucessor;
            sucessor = atual;
            atual = atual.filhoDireita; // vai para filho à esquerda
        }		// se sucessor não é filho à direita faz conexão
        if (sucessor != deleteNo.filhoDireita){
            sucessorParente.filhoDireita = sucessor.filhoDireita;
            sucessor.filhoDireita = deleteNo.filhoDireita;
        }
        return sucessor;
    }

    /*
     * O método travesseia apaga um nó da árvore passado como
     * parâmetro pela variável chave
     */
    public void travessia(int tipoTravessia) {
        switch (tipoTravessia) {
            case 1:
                System.out.print("\nTravessia usando Preorder: ");
                preOrder(raiz);
                break;
            case 2:
                System.out.print("\nTravessia usando Inorder:  ");
                inOrder(raiz);
                break;
            case 3:
                System.out.println("\nTravessia usando Postorder: ");
                posOrder(raiz);
                break;
        }
        System.out.println();
    }

    /*
     * O método preOrder
     */
    private void preOrder(No localraiz) {
        if (localraiz != null) {
            localraiz.mostraNo();
            preOrder(localraiz.filhoEsquerda);
            preOrder(localraiz.filhoDireita);
        }
    }

    /*
     * O método inOrder
     */
    private void inOrder(No localraiz) {
        if (localraiz != null) {
            inOrder(localraiz.filhoEsquerda);
            localraiz.mostraNo();
            inOrder(localraiz.filhoDireita);
        }
    }

    /*
     * O método posOrder
     */
    private void posOrder(No localraiz) {
        if (localraiz != null) {
            posOrder(localraiz.filhoEsquerda);
            posOrder(localraiz.filhoDireita);
            localraiz.mostraNo();
        }
    }
}