#include <stdio.h>

int main(int argc, char const *argv[]){
    // Inicializando variaveis
    int n, r;

    printf("Digite um valor de n: ");
    scanf("%i", &n);
    printf("\n");

    r = 1;

    // Calculo
    while(n > 1){
        n -= 2;
        r = r * 2 + 10;
    }

    // Mostrando o resultado
    printf("Resposta: %i", r);
    return 0;
}