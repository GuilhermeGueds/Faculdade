#ifndef GAME_H_INCLUDED
#define GAME_H_INCLUDED
#include <iostream>
#include "Baralho.h"
#include"Jogador.h"
#include"tela.h"
#include <stddef.h>

using namespace std;
class Game{

private:

Tela tela;
Jogador* jogador1 = new Jogador("Bruce", false);
Jogador* jogador2 = new Jogador("", true);
Baralho* baralho = new Baralho();
int opcao;
bool gameOver = false;
int contador = 2;
char resp = 'n';
void iniciaJogo();
void proximaRodada();
void humano();
void bot();
void campeao();
public:
~Game();
void run();

};

#endif // GAME_H_INCLUDED
