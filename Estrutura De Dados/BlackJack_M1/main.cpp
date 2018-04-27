#include <iostream>
#include"Game.h"
#include"Lista.h"
int main(){
char resp;
 do
    {
    Game game;
    Tela tela;

        game.run();
        resp = tela.resposta();

    }
    while(resp == 's');


    return 0;

}

