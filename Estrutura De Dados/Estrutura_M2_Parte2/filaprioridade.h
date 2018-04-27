#ifndef FILAPRIORIDADE_H
#define FILAPRIORIDADE_H
#include <iostream>
#include <string>
#include "Lista.h"
#include "Lista.cpp"

using namespace std;

/**(6,0 pontos) Uma fila de prioridade corresponde a uma fila em que est� associada uma
prioridade aos seus elementos, ou seja, cada elemento na fila deve possuir uma informa��o adicional que
representa a prioridade do elemento. Assim, o elemento de maior prioridade deve ser o primeiro a ser
removido da fila, quando ocorrer uma remo��o.
Implemente uma classe para a abstra��o fila de prioridade representada atrav�s de uma estrutura
din�mica duplamente encadeada, desenvolvendo opera��es e rela��es (m�todos) para criar uma fila,
destruir uma fila, verificar se um elemento existe na fila, inserir um elemento na fila, retirar um
elemento da fila e mostrar uma fila. */

template <class T>
class FilaPrioridade
{
    private:
        Lista<T>  fila;
        int qtdeA, qtdeB, qtdeC;
        string x;
    public:
        FilaPrioridade();
        ~FilaPrioridade();

        //void criarFila(string nome);
        //void destruirFila(string nome);
        void entradaString(int opcao);
        void mostra();
        void insere(T Elemento, char prioridade);
        void retira();
        bool existeElemento(T elemento);
};

#endif // FILAPRIORIDADE_H
