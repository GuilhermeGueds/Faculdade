#ifndef BARALHO_H_INCLUDED
#define BARALHO_H_INCLUDED
#include"lista.cpp"
#include <stdlib.h>
#include <time.h>
class Baralho{

private:
    Lista<int> baralho;

  public:
    Baralho();
    ~Baralho();

    int daUmaCarta();
    void embaralhar();
    int quantidade();


};

#endif // BARALHO_H_INCLUDED
