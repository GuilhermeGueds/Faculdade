#include "Nodo.h"



        template<class T>
        Nodo<T>::Nodo(T elemento){
            this->elemento = elemento;
            this->proximo = NULL;
            this->anterior = NULL;
        }


        template<class T>
        void Nodo<T>::setaProximo(Nodo* nodo){
            this->proximo = nodo;
        }

        template<class T>
        T Nodo<T>::pegaElemento(){
            return this->elemento;
        }

        template<class T>
        Nodo<T>* Nodo<T>::pegaProximo(){
            return this->proximo;
        }
        template<class T>
        void Nodo<T>::setaElemento(T elemento){
            this->elemento = elemento;
        }

        template<class T>
        void Nodo<T>::setaAnterior(Nodo* nodo){
            this->anterior = nodo;
        }
        template<class T>
        Nodo<T>* Nodo<T>::pegaAnterior(){
            return this->anterior;
        }
