#include <iostream>
#include "lista.h"

using namespace std;

Lista::Lista()
{
    this->numeroElementos = 0;
    this->ocupados[100] = {0};
}

Lista::~Lista()
{
    for (int i=0; i<numeroElementos; i++)
    {
        ocupados[i]=0;
    }
    numeroElementos = 0;
}
void Lista::inserir(char elemento)
{
    int i =0;
    if(this->numeroElementos == 100)
    {
        cout << "esta cheio";
    }
    else

        while (ocupados[i] == 1)
        {
            i++;
        }
    this->ocupados[i] = 1;
    this->elementos[i] = elemento;
    this->numeroElementos++;
}
void Lista::mostrarLista()
{
    Tela tela;
    tela.gotoxy(2,8);cout<<"elemento: ";
    int j;

    for (int i=0; i < this->numeroElementos; i++)
    {
        if (ocupados[i]==1)
        {
            j= j+2;
         tela.gotoxy(9+j,4); cout << this->elementos[i]<<" ";

        }
    }
}
bool Lista::elementoExiste(char elemento)
{
    int i = 0;
    bool existe = false;

    while(i < this->numeroElementos)
    {
        if(ocupados[i]==0)
        {
            i++;
        }
        else
            if(this->elementos[i] == elemento)
            {
                existe = true;
                i= this->numeroElementos;
            }
            else
                i++;
    }
    return existe;
}

void Lista::retira(char elemento){
    int i =0;
     while(i < this->numeroElementos)
    {
        if(ocupados[i]==0)
        {
            i++;
        }
        else
            if(this->elementos[i] == elemento)
            {
               ocupados[i]=0;
               i++;
            }
            else
                i++;
}
}
void Lista::insereElementosOutraLista( Lista & outraLista){

    for (int i=0; i < this->numeroElementos; i++)
    {
        if (this->ocupados[i]==1)
        {

            outraLista.inserir(this->elementos[i]);
        }
    }

}
 void Lista::elementoExisteOutraLista(Lista& outraLista){
 Tela tela;
    tela.gotoxy(2,8);cout<<"elemento: ";
    int j=0;
  for (int i=0; i < numeroElementos; i++)
    {
         j= j+1;
        if (this->ocupados[i]==1)
        {
           if( outraLista.elementoExiste(this->elementos[i])){
            tela.gotoxy(13,9+j); cout << this->elementos[i]<<" "<< "existe"<< endl;

           }else{
            tela.gotoxy(13,9+j); cout << this->elementos[i]<<" "<< "Nao existe"<< endl;
           }
        }
    }



 }
