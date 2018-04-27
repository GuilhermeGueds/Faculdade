#ifndef TELA_H_INCLUDED
#define TELA_H_INCLUDED
#include <windows.h>
#include <string>
#include <iostream>
#include <time.h>
#include <unistd.h>
#include "Jogador.h"
#include "Baralho.h"

using namespace std;

class Tela {
    private:
    int x,y,tempo;

public:
    Tela();
    ~Tela();
    void gotoxy(int,int);
    void desenhaLinhaHorizontal(int,int,int,int);
    void moldura();
    string  nome();

    int menu();
    int jogadores(Jogador &jogador1, Jogador &jogador2 );
    void vencedor(Jogador &jogador1, Jogador &jogador2,int id );
    void limpaSubMenu();
    int opcao();
    char resposta();
};
#endif // TELA_H_INCLUDED
