#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>
#include <conio.h>
#include<windows.h>
pthread_mutex_t mutex_garfo[5];
pthread_t filosofos[5];
int id[5];

void pegar_garfos(int * filo){
     printf("Filosofo %d com fome... \n",*filo);
    pthread_mutex_lock(&(mutex_garfo[*filo]));
    if(*filo < 4){
        pthread_mutex_lock(&(mutex_garfo[*filo+1]));
    }else
         pthread_mutex_lock(&(mutex_garfo[0]));


}

void largar_garfos(int * filo){
     pthread_mutex_unlock(&(mutex_garfo[*filo]));
    if(*filo < 4){
        pthread_mutex_unlock(&(mutex_garfo[*filo+1]));
    }else
         pthread_mutex_unlock(&(mutex_garfo[0]));
    printf("_____________________________________________________________________Filosofo %d terminou de comer.\n", *filo);
}

void * vida_filosofo (void * var){
    int * filo = (int *) (var);
    while(1){
        int pensar = (rand()%10+2);
        printf("Filosofo %d Pensando... \n",*filo);
        Sleep(pensar);
        pegar_garfos(filo);
        int comer = (rand()%5+1);
          printf("--------------------------------------Filosofo %d esta comendo \n", *filo);
        Sleep(comer);
        largar_garfos(filo);

    }
    pthread_exit(NULL);
}

void main(){
    int i=0, j=0;
    for( i = 0; i <= 4; i++){
        pthread_mutex_init(&(mutex_garfo[i]),NULL);



    }
   for( j = 0; j <= 4; j++){
        id[j] = j;
        pthread_create(&filosofos[j],NULL, &vida_filosofo,(void *) & id[j]);
   }
    while(1);

    return 0;
}
