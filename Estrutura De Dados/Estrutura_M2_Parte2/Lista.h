#ifndef LISTA_H_INCLUDED
#define LISTA_H_INCLUDED
#include<iostream>
#include "Nodo.h"

template <class T>
class Lista {
    private:
        int numeroElementos;
        Nodo<T>* inicio,*fim;
    public:

        Lista();
        ~Lista();
        bool ehVazia();
        int numeroDeElementos();
        bool existeElemento(T elemento);
        T umElemento(int posicao);
        int posicao(T elemento);
        void insere(T elemento, int posicao);
        void retiraInicio();
        void retiraFim();
        void retiraElemento(T elemento);
        void mostra(int, int, int);

        T pegaInicio();
        T pegaFim();


};



#endif // LISTA_H_INCLUDED
