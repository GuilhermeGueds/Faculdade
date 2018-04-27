#include <iostream>
#include "Game.h"
using namespace std;

/**
    destrutor
*/
Game::~Game()
{
    baralho->~Baralho();
    jogador1->~Jogador();
    jogador2->~Jogador();

}
//-------------------------------------------------------------------------------------------------------------------------------------
/**
    inicia o jogo cada jogador com 2 cartas
*/
void Game::iniciaJogo()
{
    jogador2->setNome(tela.nome());
    for (int i=0; i<2; i++)
    {
        jogador1->compra(baralho->daUmaCarta());
        jogador2->compra(baralho->daUmaCarta());
    }
    opcao =  tela.jogadores(*jogador1,*jogador2);
    if(opcao == 1)
    {
        jogador2->compra(baralho->daUmaCarta());
    }
    else
    {
        jogador2->setVez(false);
        jogador1->setVez(true);
    }
}
//-------------------------------------------------------------------------------------------------------------------------------------
/**
    insere uma carta a mao do jogador
*/
void Game::bot()
{
    jogador1->compra(baralho->daUmaCarta());

}
//-------------------------------------------------------------------------------------------------------------------------------------
/**
    jogador humano joga
    tela retorna pula ou compra
*/
void Game::humano()
{
    opcao =  tela.jogadores(*jogador1,*jogador2);
    if(opcao == 1)
    {
        jogador2->compra(baralho->daUmaCarta());

    }
    else
    {
        jogador2->setVez(false);
        jogador1->setVez(true);
    }
}

//-------------------------------------------------------------------------------------------------------------------------------------
/**
verifica pontos para ver quem foi o campeao
*/
void Game:: campeao()
{
   if (jogador1->getPontos()== jogador2->getPontos()&& jogador2->getPontos() < 21 && jogador1->getPontos()< 21)
    {
        tela.vencedor(*jogador1,*jogador2,1);
    }
    else if (jogador1->getPontos() > jogador2->getPontos()&& jogador1->getPontos()<= 21)
    {
        tela.vencedor(*jogador1,*jogador2,1);
    }
    else if (jogador2->getPontos() > jogador1->getPontos()&& jogador2->getPontos()<= 21)
    {
        tela.vencedor(*jogador1,*jogador2,2);
    }
    else if (jogador2->getPontos() > 21&& jogador1->getPontos()<= 21)
    {
        tela.vencedor(*jogador1,*jogador2,1);
    }
    else if (jogador1->getPontos() > 21&& jogador2->getPontos()<= 21)
    {
        tela.vencedor(*jogador1,*jogador2,2);
    }
    else if(jogador2->getPontos() > 21 && jogador1->getPontos()> 21)
    {
        tela.vencedor(*jogador1,*jogador2,3);
    }
}
//-------------------------------------------------------------------------------------------------------------------------------------
/**
chama a proxima rodada caso nenhum dos jogadores
encerre a partida
*/
void Game:: proximaRodada()
{
    jogador1->contaMao();
    jogador2->contaMao();


    if(jogador1->getPontos()>16 && jogador1->getVez())
    {
        gameOver = true;
    }
    else if(jogador1->getVez() && gameOver == false )
    {
        bot();
    }
    else if(jogador2->getVez() && gameOver == false)
    {
        humano();

    }

}
//-------------------------------------------------------------------------------------------------------------------------------------
/**
    metodo que chama o jogo
*/
void Game:: run()
{
    baralho->embaralhar();
    iniciaJogo();

    while( gameOver!= true)
    {
        proximaRodada();
    }
    campeao();
}




