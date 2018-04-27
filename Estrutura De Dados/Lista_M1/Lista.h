#ifndef LISTA_H
#define LISTA_H
#include "Tela.h"

class Lista
{
    private:
        int numeroElementos;
        char elementos [100];
        int ocupados [100];

    public:
        Lista();
        virtual ~Lista();
        void inserir(char elemento);
        void mostrarLista();
        void retira(char elemento);
        bool elementoExiste(char elemento);
        void insereElementosOutraLista( Lista & outraLista);
        void elementoExisteOutraLista(Lista & outraLista);
};

#endif // LISTA_H
