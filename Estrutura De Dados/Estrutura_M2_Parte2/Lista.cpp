#include "Lista.h"
#include "Nodo.cpp"

using namespace std;
/**

*/


//------------------------------------------------------------------------------------------
/**

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

*/
template<class T>
bool Lista<T>::ehVazia()
{
    return numeroDeElementos() == 0;
}
//--------------------------------------------------------------------------------------------
template<class T>
int Lista<T>::numeroDeElementos()
{

    return this->numeroElementos;
}
//-----------------------------------------------------------------------------------------------
/**
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
*/
template<class T>
void Lista<T>::insere(T elemento, int posicao)
{
    Nodo<T>* nodo = new Nodo<T>(elemento);

    if (this->inicio == NULL)
        this->inicio = nodo;
    else
    {
        if (posicao == 1)
        {
            nodo->setaProximo(this->inicio);
            this->inicio->setaAnterior(nodo);
            this->inicio = nodo;
        }
        else
        {
            Nodo<T>* nodoAnterior = this->inicio;
            int i = 1;
            while (i != posicao - 1)
            {
                nodoAnterior = nodoAnterior->pegaProximo();
                i++;
            }
            nodo->setaProximo(nodoAnterior->pegaProximo());
            nodoAnterior->setaProximo(nodo);
            nodo->setaAnterior(nodoAnterior);
        }
    }
    this->numeroElementos++;
}

//-----------------------------------------------------------------------------------------------------
/**
*/
template<class T>
void Lista<T>::retiraInicio()
{
    Nodo<T> *nodo = this->inicio;
    this->inicio = this->inicio->pegaProximo();
    this->inicio->setaAnterior(NULL);
    delete nodo;
    this->numeroElementos--;
}
//------------------------------------------------------------------------------------------------------
/**

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
*/
template<class T>
T Lista<T>::pegaInicio()
{
    return this->inicio->pegaElemento();
}
//--------------------------------------------------------------------------------------------------------------------
/**
*/
template<class T>
T Lista<T>::pegaFim()
{
    return this->fim->pegaElemento();
}
//--------------------------------------------------------------------------------------------------------------------
/**
*/
template<class T>
void Lista<T>::mostra(int QtdeA, int QtdeB, int QtdeC)
{
    Nodo<T>* nodo = this->inicio;
    while (nodo != NULL)
    {
        if (QtdeA>0)
        {
            cout << "- A[" << nodo->pegaElemento() << "]"<<"";
            QtdeA--;
        }
        else if (QtdeB > 0) {
            cout << "- B[" << nodo->pegaElemento() << "]"<<"";
            QtdeB--;
        }
        else{
            cout << "- C[" << nodo->pegaElemento() << "]"<<"";
            QtdeC--;
        }
        nodo = nodo->pegaProximo();

    }
    cout << endl;
}
//---------------------------------------------------------------------------------------------------------------------------

template<class T>
bool Lista<T>::existeElemento(T elemento){
     Nodo<T>* nodo = this->inicio;

     while(nodo!=NULL){
        if(nodo->pegaElemento() == elemento)
            return true;
        else
            nodo = nodo->pegaProximo();

     }
    return false;
}
