#ifndef TELA_H_INCLUDED
#define TELA_H_INCLUDED
#include <windows.h>
#include <string>
#include <iostream>
#include <time.h>
#include <unistd.h>
#include <stddef.h>
#include"lista.h"

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
    int menu();
    void listaNome();
    int verifica();
    void verificaDuasLista(int& x, int& y);
    int proucuraNome(string nome);
    char insere(int x);
    void retirado();
    void limpaTela();
    void pausa();
    char verificaElemento(int x,char &elemento);
    void existe();
    void naoExiste();
    void listaCopiada();
    void duasLista(int & x, int & y);
    void ListasDisponiveis();
    void excluiNome(int x);
};
#endif // TELA_H_INCLUDED
