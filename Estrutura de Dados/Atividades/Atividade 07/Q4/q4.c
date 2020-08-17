#include <stdio.h>

int main(int argc, char const *argv[]){
    // Inicializando variaveis
    int n, r;

    printf("Digite um valor de n: ");
    scanf("%i", &n);
    printf("\n");

    r = 2;

    // Calculo
    while(n > 2){
        n--;
        r = r * 2 + 3;
    }

    // Mostrando o resultado
    printf("Resposta: %i", r);
    return 0;
}