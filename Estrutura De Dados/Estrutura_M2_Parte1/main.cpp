#include <iostream>
#include "FilaEstatica.h"
#include "Tela.h"

using namespace std;

int main()
{

    int filas =0, tipo, resposta = 0, x;
    int contador =0;
    Tela tela;
    string nome;
    FilaEstatica *a;


    do
    {
        tipo = tela.menu1();
    }while(tipo < 0 || tipo > 1);
    a = new FilaEstatica(tipo);
    while (resposta!=4)
    {
        resposta = tela.menu2();
        switch(resposta)
        {
        case 1:
            if (tipo == 1)
            {
                a->insereInicio(tela.verifica());
            }
            else
            {
                a->insereFim(tela.verifica());
            }
            break;
        case 2:
            tela.posiciona();
            if (tipo == 0)
            {
                a->retiraInicio();
            }
            else
            {
                a->retiraFim();
            }
            tela.retirado();
            break;
        case 3:
            tela.posiciona();
            a->mostra();
            tela.pausa();
            break;
        case 4:
            tela.pausa();
            return 0;
        }
    }
}

