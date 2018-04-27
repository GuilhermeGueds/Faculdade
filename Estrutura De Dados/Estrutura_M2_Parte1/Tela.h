#ifndef TELA_H_INCLUDED
#define TELA_H_INCLUDED
#include <windows.h>
#include <string>
#include <iostream>
#include <time.h>
#include <unistd.h>
#include <stddef.h>
#include "FilaEstatica.h"

using namespace std;

class Tela {
    private:
    int tempo;
    string nomes[100] = {""};
    int contNome = 0;

public:
    Tela();
    ~Tela();
    void gotoxy(int,int);
    void desenhaLinhaHorizontal(int,int,int,int);
    void moldura();
    int menu1();
    int menu2();
    void listaNome();
    int verifica();
    int proucuraNome(string nome);
    void retirado();
    void limpaTela();
    void pausa();
    void posiciona();


};
#endif // TELA_H_INCLUDED
