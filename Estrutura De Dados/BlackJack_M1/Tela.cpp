#include "Tela.h"

Tela::Tela(){

}

Tela::~Tela(){

}

void Tela::gotoxy(int x, int y){
    COORD point; point.X = x; point.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), point);
}

void Tela::desenhaLinhaHorizontal(int linha, int colunaInicial, int colunaFinal, int valCarac){
    gotoxy(colunaInicial,linha);
    for(int i=colunaInicial; i <= colunaFinal; i++) cout.put(valCarac);
}
//--------------------------------------------------------------------------------------------
void Tela::moldura(){
    system("CLS");
    gotoxy(35,1); cout <<"Black Jack";


    desenhaLinhaHorizontal (2, 31, 50,223);
    desenhaLinhaHorizontal (3, 1, 78, 205);
    desenhaLinhaHorizontal(20, 1, 78, 205);
    for(int i=4;i<20;i++){
        desenhaLinhaHorizontal(i, 51, 51, 186);
        desenhaLinhaHorizontal(i, 78, 78, 186);
        desenhaLinhaHorizontal(i, 1, 1, 186);
    }
    gotoxy(51,3);cout.put(203);gotoxy(78,3);cout.put(187);
    gotoxy(51,20);cout.put(202);gotoxy(78,20);cout.put(188);
    gotoxy(1,3);cout.put(201);gotoxy(1,20);cout.put(200);
}
string Tela::nome(){
    this->moldura();
    string nome;
    gotoxy(55,5); cout <<"digite seu nome";
    gotoxy(55,7);cin >> nome;

    return nome;


}

int Tela:: jogadores(Jogador &jogador1, Jogador &jogador2 ){
    int x=0;
    int j=4;
    system("CLS");
    moldura();
     gotoxy(3,5); cout <<jogador1.getNome() <<":  ";
     if(jogador1.mostraUmaCarta() == 1){
        gotoxy(10,5); cout <<"["<<"A"<<"]";
     }else
      if(jogador1.mostraUmaCarta() == 11){
                  gotoxy(10,5); cout <<"["<<"J"<<"]";
            }else
                if(jogador1.mostraUmaCarta() == 12){
                     gotoxy(10,5); cout <<"["<<"Q"<<"]";
                }else
                    if(jogador1.mostraUmaCarta() == 13){
                         gotoxy(10,5); cout <<"["<<"K"<<"]";
                    }else
                        if(jogador1.mostraUmaCarta()!= 1 || jogador1.mostraUmaCarta() != 11 || jogador1.mostraUmaCarta()!= 12 || jogador1.mostraUmaCarta()!=13){
                        gotoxy(10,5); cout <<"["<<jogador1.mostraUmaCarta()<<"]";
                        }

    gotoxy(25,11); cout.put(178);
    gotoxy(26,11); cout.put(178);
    gotoxy(27,11); cout.put(178);
    gotoxy(3,18);cout << jogador2.getNome()<< ":  ";
    for(int i =1; i<= jogador2.quantidadeCartas();i++){
             j += 4;
        if(jogador2.mostraMao(i) == 1){
            gotoxy(2+j,18); cout <<"["<<"A"<<"]";
        }else
            if(jogador2.mostraMao(i) == 11){
                 gotoxy(2+j,18); cout <<"["<<"J"<<"]";
            }else
                if(jogador2.mostraMao(i) == 12){
                    gotoxy(2+j,18); cout <<"["<<"Q"<<"]";
                }else
                    if(jogador2.mostraMao(i) == 13){
                        gotoxy(2+j,18); cout <<"["<<"K"<<"]";
                    }else
                        if(jogador2.mostraMao(i)!= 1 || jogador2.mostraMao(i) != 11 || jogador2.mostraMao(i)!= 12 || jogador2.mostraMao(i)!=13){
                        gotoxy(2+j,18); cout <<"["<<jogador2.mostraMao(i)<<"]";

                        }

    }
    jogador2.contaMao();
    gotoxy(40,18); cout<<"mao: "<< "("<<jogador2.getPontos()<<")";
    x = opcao();
    return x;


}

int Tela:: opcao(){
    int x=0;
    while(x != 1 && x != 2){
    gotoxy(62,5); cout<<"opcao";
    gotoxy(54,8); cout<<"(1): "<<"comprar";
    gotoxy(54,10); cout<<"(2): "<<"parar";

    gotoxy(62,12);cin >>x;
    if(x != 1 && x != 2){
         tempo = clock();
     gotoxy(56,15);   cout << "opcao invalida"  ;
    while(clock() - tempo < 1000);
    gotoxy(62,12);   cout << "   ";
    gotoxy(56,15);   cout << "                    ";
    }
    }

    return x;

}

void Tela::vencedor(Jogador &jogador1, Jogador &jogador2, int id ){
    limpaSubMenu();
    int j=4;

    if(id == 1){
       gotoxy(60,5); cout  <<"Vencedor";
        gotoxy(61,7); cout <<jogador1.getNome();
         for(int i =2; i<= jogador1.quantidadeCartas();i++){
             j += 4;
            if(jogador1.mostraMao(i) == 1){
                gotoxy(6+j,5); cout <<"["<<"A"<<"]";
                gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
            }else
                if(jogador1.mostraMao(i) == 11){
                    gotoxy(6+j,5); cout <<"["<<"J"<<"]";
                    gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                }else
                    if(jogador1.mostraMao(i) == 12){
                        gotoxy(6+j,5); cout <<"["<<"Q"<<"]";
                        gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                    }else
                        if(jogador1.mostraMao(i) == 13){
                            gotoxy(6+j,5); cout <<"["<<"K"<<"]";
                            gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                        }else
                            if(jogador1.mostraMao(i)!= 1 || jogador1.mostraMao(i) != 11 || jogador2.mostraMao(i)!= 12 || jogador2.mostraMao(i)!=13){
                            gotoxy(6+j,5); cout <<"["<<jogador1.mostraMao(i)<<"]";
                             gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                            }

        }


    }else
        if(id == 2){
            gotoxy(60,5); cout  <<"Vencedor";
            gotoxy(61,7); cout <<jogador2.getNome();
            for(int i =2; i<= jogador1.quantidadeCartas();i++){
             j += 4;
            if(jogador1.mostraMao(i) == 1){
                gotoxy(6+j,5); cout <<"["<<"A"<<"]";
                gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
            }else
                if(jogador1.mostraMao(i) == 11){
                    gotoxy(6+j,5); cout <<"["<<"J"<<"]";
                    gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                }else
                    if(jogador1.mostraMao(i) == 12){
                        gotoxy(6+j,5); cout <<"["<<"Q"<<"]";
                        gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                    }else
                        if(jogador1.mostraMao(i) == 13){
                            gotoxy(6+j,5); cout <<"["<<"K"<<"]";
                            gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                        }else
                            if(jogador1.mostraMao(i)!= 1 || jogador1.mostraMao(i) != 11 || jogador2.mostraMao(i)!= 12 || jogador2.mostraMao(i)!=13){
                            gotoxy(6+j,5); cout <<"["<<jogador1.mostraMao(i)<<"]";
                             gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                            }

            }
        }else
         if(id == 3){
            gotoxy(60,5); cout  <<" Sem Vencedor";
            for(int i =2; i<= jogador1.quantidadeCartas();i++){
             j += 4;
            if(jogador1.mostraMao(i) == 1){
                gotoxy(6+j,5); cout <<"["<<"A"<<"]";
                gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
            }else
                if(jogador1.mostraMao(i) == 11){
                    gotoxy(6+j,5); cout <<"["<<"J"<<"]";
                    gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                }else
                    if(jogador1.mostraMao(i) == 12){
                        gotoxy(6+j,5); cout <<"["<<"Q"<<"]";
                        gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                    }else
                        if(jogador1.mostraMao(i) == 13){
                            gotoxy(6+j,5); cout <<"["<<"K"<<"]";
                            gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                        }else
                            if(jogador1.mostraMao(i)!= 1 || jogador1.mostraMao(i) != 11 || jogador2.mostraMao(i)!= 12 || jogador2.mostraMao(i)!=13){
                            gotoxy(6+j,5); cout <<"["<<jogador1.mostraMao(i)<<"]";
                             gotoxy(40,5); cout<<"mao: "<< "("<<jogador1.getPontos()<<")";
                            }

        }
        }
}
void Tela:: limpaSubMenu(){

    gotoxy(62,5); cout<<"            ";
    gotoxy(54,8); cout<<"            ";
    gotoxy(54,10); cout<<"           ";
    gotoxy(62,12); cout<<"       ";


}

  char Tela::resposta(){
    char resposta;
    while(resposta!='s'&& resposta!='n'){
      gotoxy(55,18);cout<<" Repitir S/N";
      gotoxy(73,18);cin>> resposta;
    }
    return resposta;
  }
