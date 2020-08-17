#include <stdio.h>

int main(int argc, char const *argv[]){
    // Inicializando variaveis
    int n, r;

    printf("Digite um valor de n: ");
    scanf("%i", &n);
    printf("\n");
    
    r = 1;

    // Calculo
    while (n > 0){
        r *= 2;
        n--;
    }

    // Mostrando o resultado
    printf("Resposta: %i\n", r);
    return 0;
}