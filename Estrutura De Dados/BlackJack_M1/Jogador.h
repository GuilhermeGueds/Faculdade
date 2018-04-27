#ifndef JOGADOR_H_INCLUDED
#define JOGADOR_H_INCLUDED
#include<iostream>
#include"Lista.h"

#include <stdlib.h>
using namespace std;
class Jogador{

private:
    string nome;
    int pontos;
    Lista<int> mao;
     bool vez;
public:
    Jogador(string nome, bool vez);
    ~Jogador();

    void  setNome(string nome);
    string getNome();

    void  setPontos(int pontos);
    int getPontos();

    void setVez(bool vez);
    bool getVez();

    void compra(int carta);
    int mostraUmaCarta();
    int mostraMao(int i);
    int quantidadeCartas();
    void contaMao();



};

#endif // JOGADOR_H_INCLUDED
