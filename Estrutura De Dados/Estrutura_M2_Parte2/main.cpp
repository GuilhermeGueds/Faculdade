#include <iostream>
#include "filaprioridade.cpp"
#include "Tela.h"

using namespace std;

/**(6,0 pontos) Uma fila de prioridade corresponde a uma fila em que est� associada uma
prioridade aos seus elementos, ou seja, cada elemento na fila deve possuir uma informa��o adicional que
representa a prioridade do elemento. Assim, o elemento de maior prioridade deve ser o primeiro a ser
removido da fila, quando ocorrer uma remo��o.
Implemente uma classe para a abstra��o fila de prioridade representada atrav�s de uma estrutura
din�mica duplamente encadeada, desenvolvendo opera��es e rela��es (m�todos) para criar uma fila,
destruir uma fila, verificar se um elemento existe na fila, inserir um elemento na fila, retirar um
elemento da fila e mostrar uma fila. */

int main()
{
    FilaPrioridade<int> *filaprioridade[100];
    int filas =0, resposta = 0, x;
    int contador =0;
    Tela tela;
    string nome;

    while(resposta!=9)
    {
        resposta = tela.menu();

        switch(resposta)
        {
        case 1:
            tela.listaNome();
            filaprioridade[filas] = new FilaPrioridade<int>();
            filas++;
            break;
        case 2:
            contador++;
            x =tela.verifica();
            filaprioridade[x]->insere(contador, tela.insere(x));
            break;
        case 3:
            x = tela.verifica();
            filaprioridade[x]->retira();
            tela.retirado();
            break;
        case 4:
            x =tela.verifica();
           tela.gotoxy(2,10); filaprioridade[x]->mostra();
            tela.pausa();
            break;
        case 5:
            x =tela.verifica();
            if(filaprioridade[x]->existeElemento(tela.verificaElemento(x)))
                tela.existe();
            else
                tela.naoExiste();
            break;
        case 6:
            x =tela.verifica();
            filaprioridade[x]->~FilaPrioridade();
            tela.destruido(x);
            break;
        case 7:
            cout <<" Sair";
            return 0;
            break;
    }

    }




}
