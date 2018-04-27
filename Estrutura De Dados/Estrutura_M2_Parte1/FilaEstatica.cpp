#include <iostream>
#include "FilaEstatica.h"

using namespace std;

FilaEstatica::FilaEstatica(int opcao){
    inicio = -1;
    fim = 100;
    if(opcao == 1)
        controle = true;
    else
        controle = false;
}
FilaEstatica::~FilaEstatica(){

}
void FilaEstatica::insereInicio(int elemento){

    if(this->inicio == 99){
        cout << "esta cheio";
    }else{
        inicio++;


        if(inicio != 0){
            for(int i=inicio;i>0;i--){
                deck[i] = deck[i-1];
            }
        }
    }
    deck[0] = elemento;
}
void FilaEstatica::insereFim(int elemento){

     if(this->fim == 0){
        cout << "esta cheio";
    }else{
        fim--;

        if(fim != 99){
            for(int i=fim;i<99;i++){
                deck[i] = deck[i+1];
            }
        }
    }
    deck[99] = elemento;

}
void FilaEstatica::retiraFim(){
    if(this-> inicio < 0){
        cout << "esta vazio";
    }
    else{
        this->inicio --;
        cout << "retirado";
    }

}
void FilaEstatica::retiraInicio(){
    if(this-> fim > 99){
        cout << "esta vazio";
    }
    else{
        this->fim ++;
        cout << "retirado";
    }

}

void FilaEstatica:: mostra(){
    if (controle){
        for (int i=0; i<=inicio; i++){
            cout << "[" << deck[i] << "] ";
        }
     } else

        for (int i=fim; i<100; i++){
            cout << "[" << deck[i] << "]";
        }

}
