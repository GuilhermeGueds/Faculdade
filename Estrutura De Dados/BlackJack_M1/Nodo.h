#ifndef NODO_H_INCLUDED
#define NODO_H_INCLUDED
#include <stddef.h>
//#include <cstddef>

template<class T>
class Nodo{
    private:
        T elemento;
        Nodo* proximo;
    public:
        Nodo(T elemento);
        void setaElemento(T elemento);
        void setaProximo(Nodo* nodo);
        T pegaElemento();
        Nodo* pegaProximo();
};



#endif // NODO_H_INCLUDED
