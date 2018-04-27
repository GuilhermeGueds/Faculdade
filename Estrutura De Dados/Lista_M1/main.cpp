#include <iostream>
#include "lista.h"

using namespace std;

int main()
{
    Lista* listas[100];
    int contador = 0;
    char elemento;
    string nomeLista, nomeOutraLista;
    int resposta=0;
    bool existe = false;
    Tela tela;
    int x,y;


    while(resposta!=9)
    {
        resposta = tela.menu();


        switch(resposta)
        {
        case 1:
            tela.listaNome();
            listas[contador]= new Lista();
            contador++;
            break;
        case 2:
            x =tela.verifica();
            if(x>-1)
            {
                listas[x]->inserir(tela.insere(x));
            }
            else
                tela.naoExiste();
            break;
        case 3:
            x =tela.verifica();
            if(x>-1)
            {
                if(listas[x]->elementoExiste(tela.verificaElemento(x,elemento)))
                {
                    listas[x]->retira(elemento);
                    tela.retirado();
                }
                else
                    tela.naoExiste();
            }
            break;
        case 4:
            x =tela.verifica();
            if(x>-1)
            {
                listas[x]->mostrarLista();
            }
            tela.pausa();
            break;
        case 5:
            x =tela.verifica();
            if(x>-1)
            {
                if(listas[x]->elementoExiste(tela.verificaElemento(x,elemento)))
                {
                    tela.existe();
                }
                else
                    tela.naoExiste();
            }
            break;
        case 6:
            tela.duasLista(x,y);
            if(x>-1&& y>-1)
            {
                listas[x]->insereElementosOutraLista(*listas[y]);
                tela.listaCopiada();
            }
            break;
        case 7:
            tela.duasLista(x,y);
            if(x>-1&& y>-1)
            {
                listas[x]->elementoExisteOutraLista(*listas[y]);
                tela.pausa();
            }
            break;
        case 8:
            x =tela.verifica();
            if(x>-1)
            {
                listas[x]->~Lista();
                tela.excluiNome(x);
            }

            break;

        }
    }
    tela.pausa();

    return 0;
}
