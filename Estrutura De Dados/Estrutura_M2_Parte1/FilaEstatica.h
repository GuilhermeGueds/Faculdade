#ifndef FILAESTATICA_H_INCLUDED
#define FILAESTATICA_H_INCLUDED



class FilaEstatica{

private:

     int deck[100];
     int inicio ;
     int fim ;
     bool controle;

public:

    FilaEstatica(int opcao);
    ~FilaEstatica();
    void insereInicio(int elemento);
    void insereFim(int elemento);
    void retiraInicio();
    void retiraFim();
    void mostra();

};

#endif // FILAESTATICA_H_INCLUDED
