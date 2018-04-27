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
        void insereInicio(T elemento);
        void insereFim(T elemento);
        void retiraInicio();
        void retiraFim();
         void retiraElemento(T elemento);
         T retiraPosicao(int posicao);
        void mostra();


};



#endif // LISTA_H_INCLUDED
