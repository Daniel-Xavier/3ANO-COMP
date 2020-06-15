#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char *argv[]){
    pid_t childpid = 0;
    int i, n;

    if(argc != 2){
        fprintf(stderr, "Uso: %s numero\n", argv[0]);
        return EXIT_FAILURE;
    }

    printf("\nProcesso pai comecando \t\t ID: %ld \t ID pai: %ld\n\n", (long)getpid(), (long)getppid());
    
    n = atoi(argv[1]);
    for(i = 1; i < n; i++){
        sleep(1);
        if((childpid= fork()) <= 0)
            break;
    }

    while( wait(NULL) > 0 );

    printf("Inicio do processo \t i: %i \t ID: %ld \t ID pai: %ld \t ID filho: %ld\n",
            i, (long)getpid(), (long)getppid(), (long)childpid);

    if(i < n){
        printf("Fim do processo \t i: %i \t ID: %ld \t ID pai: %ld \t ID filho: %ld\n\n",
                i, (long)getpid(), (long)getppid(), (long)childpid);
    }

    else{
        printf("\n\nProcesso pai encerrado \t ID: %ld \t ID pai: %ld\n\n", (long)getpid(), (long)getppid());
    }
    
    return 0;
}
