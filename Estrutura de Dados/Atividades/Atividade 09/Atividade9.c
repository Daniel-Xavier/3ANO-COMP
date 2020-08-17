#include <string.h>
#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct Elemento
{
    int info;
    struct Elemento *prox;
} TElemento;

typedef struct Lista
{
    TElemento *inicio;
    TElemento *fim;
} TLista;

void StartLista(TLista *lista)
{
    lista->inicio = NULL;
    lista->fim = NULL;
}

int InsertElemento(TLista *lista)
{
    TElemento *novo;

    printf("Informe o valor: \n");
    scanf("%d", &novo->info);
    novo->prox = NULL;

    if (lista->inicio == NULL)
    {
        lista->inicio = novo;
        lista->fim = novo;
    }
    else
    {
        lista->fim->prox = novo;
        lista->fim = novo;
    }
}

    void ShowElemento(TLista * lista) {
        TElemento *aux;
        aux = lista->inicio;

        if (aux == NULL)
        {
            printf("Lista vazia. \n");
        }
        else
        {
            while (aux != NULL)
            {
                printf("\n Valor: %d", aux->info);
                aux = aux->prox;
            }
        }
    }

    void RemoveElemento(TLista * lista)
    {
        int valor;
        TElemento *anterior, *atual;

        printf("Digite o elemento que deseja exlcuir: \n");
        scanf("%d", valor);

        if (lista->inicio == NULL)
        {
            printf("Lista vazia. \n");
        }
        else
        {
            anterior = lista->inicio;
            atual = lista->inicio;
            while (atual != NULL)
            {
                if (atual->info == valor)
                {
                    if (atual == lista->inicio)
                    {
                        lista->inicio = lista->inicio->prox;
                        free(atual);
                    }
                    else
                    {
                        if (atual == lista->fim)
                        {
                            lista->fim = anterior;
                        }

                        anterior->prox = atual->prox;
                        free(atual);
                        break;
                    }
                }
                else
                {
                    anterior = atual;
                    atual = atual->prox;
                }
            }
        }
    }
    int main()
    {

        TLista L1;
        StartLista(&L1);
        int op;
        do
        {
            printf("Menu: \n");
            printf("Inserir elemento (1): \n");
            printf("Exibir elementos (2): \n");
            printf("Excluir elementos (3): \n");
            printf("Sair (0): \n");
            printf("Digite uma opcao: \n");
            scanf("%d", &op);

            switch (op)
            {
                case 1:
                InsertElemento(&L1);
                break;

                case 2:
                ShowElemento(&L1);
                break;

                case 3:
                RemoveElemento(&L1);
                break;

                default:
                printf("Opcao invalida.");
                break;

            }
        }while(op != 0);

        return 0;
    }
