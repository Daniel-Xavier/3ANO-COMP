#include <stdio.h>

int main(int argc, char const *argv[]){
    // Inicializando variaveis
    int n, r;

    printf("Digite um valor de n: ");
    scanf("%i", &n);
    printf("\n");
    
    r = 1;

    // Calculo
    while (n > 1){
        r *= n;
        n--;
    }

    // Mostrando o resultado
    printf("Resposta: %i", r);
    return 0;
}