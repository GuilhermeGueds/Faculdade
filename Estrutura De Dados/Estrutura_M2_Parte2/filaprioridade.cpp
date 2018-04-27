#include "filaprioridade.h"
#include "Lista.h"


template<class T>
FilaPrioridade<T>::FilaPrioridade()
{
    qtdeA =0;
    qtdeB = 0;
    qtdeC =0;
}
template<class T>
FilaPrioridade<T>::~FilaPrioridade()
{
    fila.~Lista();
}
template<class T>
void FilaPrioridade<T>::mostra(){
    this->fila.mostra(qtdeA,qtdeB,qtdeC);
}
template<class T>
void FilaPrioridade<T>::insere(T elemento, char prioridade){
    if (prioridade == 'A'){
        qtdeA++;
        fila.insere(elemento,qtdeA);
    }else if (prioridade == 'B'){
        qtdeB++;
        fila.insere(elemento,qtdeA+qtdeB);
    }else {
        qtdeC++;
        fila.insere(elemento,qtdeA+qtdeB+qtdeC);
    }
}
template<class T>
void FilaPrioridade<T>::retira (){
    fila.retiraInicio();
    if (qtdeA>0)
        {
            qtdeA--;
        }
        else if (qtdeB > 0) {
            qtdeB--;
        }
        else{
            qtdeC--;
        }
}
template<class T>
bool FilaPrioridade<T>::existeElemento(T elemento){
    return fila.existeElemento( elemento);
}
