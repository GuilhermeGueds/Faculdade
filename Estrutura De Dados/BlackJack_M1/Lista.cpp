#include "Lista.h"
#include "Nodo.cpp"

using namespace std;
/**
Classe Lista esta circular e com tamplate
conforme os requisitos do trabalho
*/


//------------------------------------------------------------------------------------------
/**
    construtor
*/
template<class T>
Lista<T>::Lista()
{
    this->numeroElementos = 0;
    this->inicio = NULL;
    this->fim = NULL;
}
//-------------------------------------------------------------------------------------------
/**
    detrutor
*/
template<class T>
Lista<T>::~Lista()
{
    Nodo<T>* nodo;

    while(this->inicio != fim)
    {
        nodo = this->inicio;
        this->inicio = this->inicio->pegaProximo();
        delete nodo;
    }
    delete this->fim;
    this->numeroElementos = 0;
}
//--------------------------------------------------------------------------------------------
/**
    retorna verdadeiro caso esteja vazio
    outro caso retorna falso
*/
template<class T>
bool Lista<T>::ehVazia()
{
    return numeroDeElementos() == 0;
}
//--------------------------------------------------------------------------------------------
/**
    retorna numero de elementos da lista
*/
template<class T>
int Lista<T>::numeroDeElementos()
{

    return this->numeroElementos;
}
//-----------------------------------------------------------------------------------------------
/**
    retorna elemento da posiçao passado por parametro
*/
template<class T>
T Lista<T>::umElemento(int posicao)
{
    Nodo<T>* nodo = this->inicio;
    int i = 1;

    while (i != posicao)
    {
        nodo = nodo->pegaProximo();
        i++;
    }
    return nodo->pegaElemento();
}
//------------------------------------------------------------------------------------------------
/**
    insere no inicio da lista

*/
template<class T>
void Lista<T>::insereInicio(T elemento)
{
    Nodo<T>* nodo = new Nodo<T>(elemento);

    if (this->inicio == NULL)
    {
        this->inicio = nodo;
        this->fim = nodo;
        this->fim->setaProximo(this->inicio); /** nesse trecho garante que a lista é circular*/
    }
    else
    {
        nodo->setaProximo(this->inicio);
        this->inicio = nodo;
        this->fim->setaProximo(this->inicio);

    }
    this->numeroElementos++;
}
//--------------------------------------------------------------------------------------------------
/**
    insere ao final da lista
*/
template<class T>
void Lista<T>::insereFim(T elemento)
{
    Nodo<T>* nodo = new Nodo<T>(elemento);
    if (this->inicio == NULL)
    {
        this->inicio = nodo;
        this->fim = nodo;
        this->fim->setaProximo(this->inicio); /** nesse trecho garante que a lista é circular*/
    }
    else
    {
        while(this->fim->pegaProximo() != this->inicio)
        {
            this->fim= this->fim->pegaProximo();
        }
        this->fim->setaProximo(nodo);
        this->fim = nodo;
        this->fim->setaProximo(this->inicio);  /** nesse trecho garante que a lista é circular*/
    }
    this->numeroElementos++;
}
//-----------------------------------------------------------------------------------------------------
/**
    remove elemento do inicio da lista
*/
template<class T>
void Lista<T>::retiraInicio()
{
     Nodo<T> *nodo = this->inicio;
    this->inicio = this->inicio->pegaProximo();
    delete nodo;
    this->fim->setaProximo(this->inicio);  /** nesse trecho garante que a lista é circular*/
    this->numeroElementos--;
}
//------------------------------------------------------------------------------------------------------
/**
   remove elemento do final da lista
*/
template<class T>
void Lista<T>::retiraFim()
{
    Nodo<T>* nodoAnterior = this->inicio;

    while (nodoAnterior->pegaProximo() != fim)
    {
        nodoAnterior = nodoAnterior->pegaProximo();

    }
    this->fim = nodoAnterior;
    nodoAnterior = this->fim->pegaProximo();
    delete nodoAnterior;
   this->fim->setaProximo(this->inicio);
    this->numeroElementos--;
}
//---------------------------------------------------------------------------------------------------------
/**
    retira elemento da lista conforme o elemento
*/
template<class T>
void Lista<T>::retiraElemento(T elemento)
{
    Nodo<T>* nodoAnterior = this->inicio;
    Nodo<T>* nodoProximo = this->inicio;

    while (nodoProximo != fim)
    {
        if(this->inicio->pegaElemento() == elemento)
        {
            retiraInicio();
        }
        else if(this->fim->pegaElemento() == elemento)
        {
            retiraFim();
        }
        else if(nodoProximo->pegaElemento()== elemento)
        {
            while(nodoAnterior->pegaProximo()!= nodoProximo)
            {
                nodoAnterior = nodoAnterior->pegaProximo();
            }
            nodoAnterior->setaProximo(nodoProximo->pegaProximo());
            delete nodoProximo;
            nodoProximo = nodoAnterior->pegaProximo();
        }
        nodoProximo = nodoProximo->pegaProximo();
    }
    this->numeroElementos--;
}
//------------------------------------------------------------------------------------------------------------
/**
    retira elmento conforme a posiçao
    verificar no embaralhar da classe baralho
*/
template<class T>
T Lista<T>::retiraPosicao(int posicao){
T x;
    Nodo<T>* nodo = this->inicio;

    if (posicao == 1)
    {
        x = this->inicio->pegaElemento();
        retiraInicio();
    }
    else{
        Nodo<T>* nodoAnterior = this->inicio;
        int i = 1;
        while (i != posicao - 1)
        {
            nodoAnterior = nodoAnterior->pegaProximo();
            i++;
        }
            if(nodoAnterior->pegaProximo() == this->fim){
                x = this->fim->pegaElemento();
                retiraFim();
            }else{
                nodo = nodoAnterior->pegaProximo();
                x = nodo->pegaElemento();
                nodoAnterior->setaProximo(nodo->pegaProximo());
        delete nodo;
    }
    }
    this->numeroElementos--;
    return x;
}
//-----------------------------------------------------------------------------------------------------------------
/**
    retorna posiçao conforme conforme o elemnto
     passado por parametro
*/
template<class T>
int Lista<T>::posicao(T elemento)
{
    Nodo<T>* nodo = this->inicio;
    int i = 1;

    while (nodo->pegaElemento() != elemento)
    {
        nodo = nodo->pegaProximo();
        i++;
    }
    return i;
}
//--------------------------------------------------------------------------------------------------------------------
/**
    mostra elemento
*/
template<class T>
void Lista<T>::mostra()
{
    Nodo<T>* nodo = this->inicio;

     cout << "[" << nodo->pegaElemento() << "]"<<"";
    nodo = nodo->pegaProximo();
    while (nodo != this->fim->pegaProximo())
    {
        cout << "[" << nodo->pegaElemento() << "]"<<"";
        nodo = nodo->pegaProximo();
    }

}

