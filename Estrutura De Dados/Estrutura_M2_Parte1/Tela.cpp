#include "Tela.h"
#include <ctype.h>

Tela::Tela()
{
}

Tela::~Tela()
{
}

void Tela::gotoxy(int x, int y)
{
    COORD point;
    point.X = x;
    point.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), point);
}

void Tela::desenhaLinhaHorizontal(int linha, int colunaInicial, int colunaFinal, int valCarac)
{
    gotoxy(colunaInicial,linha);
    for(int i=colunaInicial; i <= colunaFinal; i++) cout.put(valCarac);
}
//--------------------------------------------------------------------------------------------
void Tela::moldura()
{
    system("CLS");
    gotoxy(35,1);cout <<"Fila";
    desenhaLinhaHorizontal (2, 31, 50,223);
    desenhaLinhaHorizontal (3, 1, 78, 205);
    desenhaLinhaHorizontal(25, 1, 78, 205);
    for(int i=4; i<25; i++)
    {
        desenhaLinhaHorizontal(i, 51, 51, 186);
        desenhaLinhaHorizontal(i, 78, 78, 186);//ultima linha vertical
        desenhaLinhaHorizontal(i, 1, 1, 186);
    }
    gotoxy(51,3);
    cout.put(203);
    gotoxy(78,3);
    cout.put(187);
    gotoxy(51,25);
    cout.put(202);
    gotoxy(78,25);
    cout.put(188);
    gotoxy(1,3);
    cout.put(201);
    gotoxy(1,25);
    cout.put(200); //cima
}

int Tela::menu1()
{
    moldura();
    int x=2;
    while(x < 0 || x >1)
    {

        gotoxy(52,4);
        cout<<"opcao: ";
        gotoxy(52,6);
        cout<<"1:"<<"Insere inicio.";
        gotoxy(52,8);
        cout<<"0:"<<"Insere fim";

        gotoxy(59,4);
        cin >>x;
        if(x < 0 || x >1)
        {
            tempo = clock();
            gotoxy(59,4);
            cout << "         ";
            gotoxy(59,4);
            cout << "invalida"  ;
            while(clock() - tempo < 1000);
            gotoxy(59,4);
            cout << "          ";
        }
    }
    return x;
}
int Tela::menu2()
{
    moldura();
    int x=0;
    while(x < 1 || x >7)
    {

        gotoxy(52,4);
        cout<<"opcao: ";
        gotoxy(52,6);
        cout<<"(1): "<<"Insere";
        gotoxy(52,8);
        cout<<"(2): "<<"Remove";
        gotoxy(52,10);
        cout<<"(3): "<<"Mostra Fila";
        gotoxy(52,12);
        cout<<"(4): "<<"--- Sair --- ";

        gotoxy(59,4);
        cin >>x;
        if(x < 1 || x >4)
        {
            tempo = clock();
            gotoxy(59,4);
            cout << "         ";
            gotoxy(59,4);
            cout << "invalida"  ;
            while(clock() - tempo < 1000);
            gotoxy(59,4);
            cout << "          ";
        }
    }
    return x;
}

void Tela::listaNome()
{
    string nome;
    bool ok =false;
    int i=0;
    while(!ok)
    {
        gotoxy(2,4);
        cout<<"Digite o nome da Lista: ";
        gotoxy(2,7);
        cin >>nome;
        if(contNome == 0)
        {
            nomes[0] = nome;
            ok=true;
            this->contNome++;
        }
        else
        {
            i =0;
            while(i<contNome )
            {
                if(nomes[i] == nome)
                {
                    tempo = clock();
                    gotoxy(2,10);
                    cout << "nome ja existe"  ;
                    while(clock() - tempo < 1000);
                    gotoxy(2,10);
                    cout << "               ";
                    gotoxy(2,7);
                    cout << "               ";
                    i=contNome+1;
                }
                else if(i==contNome-1 && nomes[i]!= nome)
                {
                    i=contNome+1;
                    nomes[contNome] = nome;
                    contNome++;
                    ok = true;
                }
                else
                    i++;
            }
        }
    }
    tempo = clock();
    gotoxy(2,10);
    cout << "Lista Criada"  ;
    while(clock() - tempo < 1000);

}

int Tela::verifica()
{
    int nome;
    bool ok =false;
    int x;
    gotoxy(2,4);
    cout<<"Digite o elemento inteiro: ";
    gotoxy(2,7);
    cin >>x;

    return x;
}



int Tela::proucuraNome(string nome)
{
    int x=0;
    int i=0;
    while(i<contNome )
    {
        if(nomes[i] == nome)
        {
            x = i;
            i=contNome+1;
        }
        else if(i==contNome-1 && nomes[i]!= nome)
        {
            x = -1;
        }
        else
            i++;
    }
    return x;
}

void Tela::retirado(){
    tempo = clock();
        gotoxy(2,10);
        tempo = clock();
        gotoxy(2,10);
        while(clock() - tempo < 1500);
}

void Tela:: limpaTela(){

    for(int n =2;n<51;n++){
        cout<<endl;
        for(int m =4; m< 25;m++){
      gotoxy(n,m);cout <<" ";
        }

    }
}


void Tela:: pausa(){
 gotoxy(2,25);system("pause");
}

void Tela::posiciona(){
    gotoxy(2,6);
}
