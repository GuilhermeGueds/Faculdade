#include "Baralho.h";
#include <stdlib.h>
#include <time.h>

/**
    Lista de cartas

    construtor
*/
Baralho::Baralho()
{
    for (int i = 1; i<=4; i++)
    {
        for(int j = 1; j <= 13; j++)
        {
            baralho.insereInicio(j);
        }
    }
}
//---------------------------------------------------------------------------------------------------------------------------------------
/**
    destrutor
*/
Baralho::~Baralho(){
baralho.~Lista();
}
//---------------------------------------------------------------------------------------------------------------------------------------
/**
    repassa uma carta para mao do jogador e
    exclui do baralho
*/
int Baralho::daUmaCarta()
{
    int x;
    x = baralho.umElemento(1);
    baralho.retiraInicio();
    return x;
}
//---------------------------------------------------------------------------------------------------------------------------------------
/**
    numero total de cartas no baralho
*/
int Baralho::quantidade(){
 return baralho.numeroDeElementos();
 }
//---------------------------------------------------------------------------------------------------------------------------------------
/**
    metodo que embaralha as cartas

    seleciona uma carta aleatoriamente da posiçao 1 a 52
    depois ele retira essa carta da posiçao em que ela se encontra
    e insere ao inicio ou ao fim do baralho
*/
void Baralho::embaralhar()
{
    srand (time(NULL));
    int x;
    for (int i =0; i<50; i++)
    {
        x =  baralho.retiraPosicao(rand() % 52+1);
        baralho.insereInicio(x);
    }
    for (int i =0; i<50; i++)
    {
        x =  baralho.retiraPosicao(rand() % 52+1);
        baralho.insereFim(x);
    }

}


