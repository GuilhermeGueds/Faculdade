#include "Jogador.h"
#include<iostream>
#include <stdlib.h>

/**
    construtor
*/
Jogador:: Jogador(string nome, bool vez)
{
    this-> nome = nome;
    this-> pontos = 0;
    this-> vez = vez;
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
    destrutor
*/
Jogador:: ~Jogador()
{
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
   seta nome do jogador
*/
void Jogador:: setNome(string nome)
{
    this->nome = nome;
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
   recupera nome
*/
string Jogador:: getNome()
{
    return nome;
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
   seta pontos do jogagdor
*/
void Jogador:: setPontos(int pontos)
{
    this-> pontos = pontos;
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
recupera pontos
*/
int Jogador::getPontos()
{
    return this->pontos;
}

//---------------------------------------------------------------------------------------------------------------------------------------------
/**
   seta vez da partida
*/
void Jogador:: setVez(bool vez)
{
    this->vez = vez;
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
recupera vencedor
*/
bool Jogador:: getVez()
{
    return vez;
}


//---------------------------------------------------------------------------------------------------------------------------------------------
/**
insere uma carta na mao do jogador
*/
void Jogador:: compra(int carta)
{
    mao.insereFim(carta);
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
   mostra uma unica carta da mao do jogador
*/
int Jogador:: mostraUmaCarta()
{
    return mao.umElemento(1);
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
  jogador mostra mão inteira
*/
int Jogador:: mostraMao(int i)
{
    return mao.umElemento(i);
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
 quantidade de cartas que o jogador tem na mao
 utilizado para controle de laço
*/
int Jogador:: quantidadeCartas()
{
    return mao.numeroDeElementos();
}
//---------------------------------------------------------------------------------------------------------------------------------------------
/**
   conta quantidade de pontos que cada jogador
   tem em suas mãos após  o jogo encerrar
*/
void Jogador::contaMao()
{
    pontos = 0;
    for(int i=1; i<=quantidadeCartas(); i++ )
    {
        if(mostraMao(i)==1 && pontos <= 10)
        {
            pontos = pontos + mostraMao(i)+10;
        }
        else if(mostraMao(i)==1 && pontos > 10)
        {
            pontos = pontos +mostraMao(i);
        }
        else if(mostraMao(i)==11 || mostraMao(i)==12 || mostraMao(i)==13 )
        {
            pontos = pontos + 10;
        }
        else if(  mostraMao(i)!=1 && mostraMao(i)!=11 && mostraMao(i)!=12 && mostraMao(i)!=13 )
        {
            pontos = pontos + mostraMao(i);
        }
    }
}


