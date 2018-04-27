#include "Tela.h"

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
    gotoxy(35,1);cout <<"Lista";
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

int Tela::menu()
{
    moldura();
    int x=0;
    while(x != 1 && x != 2&& x != 3&& x != 4&& x != 5&& x != 6&& x != 7&& x != 8 && x != 9)
    {
        gotoxy(52,4);
        cout<<"opcao: ";
        gotoxy(52,6);
        cout<<"(1): "<<"criar uma lista";
        gotoxy(52,8);
        cout<<"(2): "<<"inserir elemento";
        gotoxy(52,10);
        cout<<"(3): "<<"retirar elemento";
        gotoxy(52,12);
        cout<<"(4): "<<"mostrar lista";
        gotoxy(52,14);
        cout<<"(5): "<<"verificar elemento";
        gotoxy(52,16);
        cout<<"(6): "<<"inserir elemento de";
        gotoxy(57,17);
        cout<<"lista em outra lista";
        gotoxy(52,19);
        cout<<"(7): "<<"verifica elemento de";
        gotoxy(57,20);
        cout<<"lista existe em outra";
        gotoxy(52,22);
        cout<<"(8): "<<"destruir uma lista";
        gotoxy(52,24);
        cout<<"(9): "<<"sair";

        gotoxy(59,4);
        cin >>x;
        if(x != 1 && x != 2&& x != 3&& x != 4&& x != 5&& x != 6&& x != 7&& x != 8 && x != 9)
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
    ListasDisponiveis();
    string nome;
    bool ok =false;
    int x;
    gotoxy(2,4);
    cout<<"Digite o nome da Lista: ";
    gotoxy(27,4);
    cin >>nome;

    x= proucuraNome(nome);
    if(x<0)
    {
        tempo = clock();
        gotoxy(2,10);
        cout << "nome Nao existe"  ;
        while(clock() - tempo < 1000);
    }

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
        else
            if(i==contNome-1 && nomes[i]!= nome)
            {
            x = -1;
            return x;
            }
        else
            i++;
    }
      return x;
}
char Tela::insere(int x){
limpaTela();
   char n;

    gotoxy(2,4);cout<<"Lista: "<< nomes[x];
     gotoxy(2,6);cout<<"Digite caracter para adicionar ";
    gotoxy(2,8);cin >>n;

  tempo = clock();
        gotoxy(2,10);
        cout << "Adicionado"  ;
        while(clock() - tempo < 1000);
return n;
}

void Tela::retirado(){
    tempo = clock();
        gotoxy(2,10);
        cout << "Elemento retirado"  ;
        while(clock() - tempo < 1000);
}

void Tela:: limpaTela(){

    for(int n =2;n<51;n++){
        cout<<endl;
        for(int m =4; m< 25;m++){
      gotoxy(n,m);cout <<" ";
        }

    }
}

 char Tela::verificaElemento(int x,char &elemento){
     limpaTela();

    gotoxy(2,4);cout<<"Lista: "<< nomes[x];
     gotoxy(2,6);cout<<"Digite caracter para verificar ";
    gotoxy(2,8);cin >>elemento;
    return elemento;
 }
 void Tela::existe(){
     tempo = clock();
        gotoxy(2,10);
        cout << "Elemento Existe"  ;
        while(clock() - tempo < 1000);

 }
    void Tela::naoExiste(){
     tempo = clock();
        gotoxy(2,10);
        cout << "Elemento Nao Existe"  ;
        while(clock() - tempo < 1000);
    }
void Tela::listaCopiada(){
 tempo = clock();
        gotoxy(2,10);
        cout << "Lista Copiada com sucesso " ;
        while(clock() - tempo < 1000);
}
void Tela:: pausa(){
 gotoxy(2,24);system("pause");
}

void Tela:: duasLista(int & x, int & y){
    limpaTela();
    ListasDisponiveis();
      string nomex;
      string nomey;
    gotoxy(2,4);
    cout<<"Digite o nome da Lista: ";
    gotoxy(26,4);
    cin >>nomex;

    x= proucuraNome( nomex);
    if(x<0)
    {
        tempo = clock();
        gotoxy(2,10);
        cout << "nome Nao existe"  ;
        while(clock() - tempo < 1000);
    }

    gotoxy(2,5);
    cout<<"Digite o nome da Outra Lista: ";
    gotoxy(32,5);
    cin >>nomey;

    y= proucuraNome( nomey);
    if(y<0)
    {
        tempo = clock();
        gotoxy(2,10);
        cout << "nome Nao existe"  ;
        while(clock() - tempo < 1000);
    }
}

 void Tela::ListasDisponiveis(){
    int j=0;

      gotoxy(2,18);cout << "Listas Disponiveis: " ;
    for (int i=0; i<= contNome;i++){
            j = j+1;
        if(nomes[i]!=" "){
            gotoxy(2,19+j);cout << nomes[i] ;
        }
    }

 }
void Tela::excluiNome(int x){

    nomes[x] = " ";

}
