% Autor: Guilherme Guedes
% Data: 16/05/2018
% Exercicio 7


ligacao(1,2).
ligacao(1,3).
ligacao(2,4).
ligacao(3,4).
ligacao(3,6).
ligacao(4,6).
ligacao(5,6).

concatena([],L,L).
concatena([X|L1],L2,[X|L3]):- concatena(L1,L2,L3).

%----------------------------------------------------------------------------------------
% A)

ligacao2(X,Y):- ligacao(X,Y).
ligacao2(X,Y):- ligacao(Y,X).

caminho(Inicio, Fim, Lista):- caminho(Inicio, Fim, [Inicio], Lista, 5).

caminho(Inicio, Fim, Lista, ListaFim,_):- ligacao2(Inicio, Fim),
                                          concatena(Lista, [Fim], ListaFim).

caminho(Inicio, Fim, Lista, ListaFim, N):- N>0, ligacao2(Inicio, Interm),
                                           Interm \= Fim, \+(member(Interm, Lista)),
                                           concatena(Lista, [Interm], Lista2), N2 is N-1,
                                           caminho(Interm, Fim, Lista2, ListaFim, N2).

%------------------------------------------------------------------------------------------

%------------------------------------------------------------------------------------------
%B)

ciclos(No, Comp, Lista):- findall(Ciclo, caminho(No, No, [], Ciclo, Comp), Lista).

%------------------------------------------------------------------------------------------


% Resolução

%A)   caminho(2,3, Lista).
%B)   ciclos(4, 3, Lista).
