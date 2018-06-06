% Autor: Guilherme Guedes
% Data: 16/05/2018
% Exercicio 4



%A) Construa o predicado lista_ate(N,L) que devolva a lista L de todos os números inteiros entre 1 e N.

listaA(0,[]).
listaA(Inicio,[Inicio|Resto]):- Inicio1 is Inicio-1,listaA(Inicio1,Resto),!.




%----------------------------------------------------------------------------------------------------------
%B)  Construa o predicado lista_entre(N1,N2,L) que devolva a lista L de todos os números inteiros entre  N1 e N2 (ambos incluídos).

listaB( Fim, Fim,[ Fim]).
listaB( Inicio , Fim,[ Inicio| Resto]) :-  Inicio1 is Inicio+1,
                                        listaB( Inicio1 , Fim, Resto),!.


%------------------------------------------------------------------------------------------------------------

%C)  Construa o predicado soma_lista(L,Soma) que some todos os elementos da lista L, obtendo como resultado Soma.

soma([],0).
soma([X|Y],S):- soma(Y,R), S is R + X.

%-------------------------------------------------------------------------------------------------------------

%D) Escreva o predicado par(N) que dado um número inteiro N, determine se ele é ou não um número par.

par(N):- N mod 2 =:= 0.

%-------------------------------------------------------------------------------------------------------------

%E) Escreva o predicado lista_pares(N,Lista) que aceite um número inteiro e que determine a lista de todos os números pares iguais ou inferiores a esse número.

lista_pares(0,[0]).
lista_pares(Inicio,[Inicio|Resto]):-(par(Inicio) -> Inicio1 is Inicio -2; Inicio1 is Inicio -1),lista_pares(Inicio1,Resto),!.


%-------------------------------------------------------------------------------------------------------------

%F) Construa o predicado ultimoElemento(Lista,X) para encontrar o último elemento de uma lista qualquer.

    ultimo([X],X).
    ultimo([_|T],X):- ultimo(T,X).
%-------------------------------------------------------------------------------------------------------------

%G) Construa o predicado maiorElemento(Lista,X) para encontrar o maior elemento de uma lista qualquer.

maiorElemento([X],X).
maiorElemento([X|Y],M):- maiorElemento(Y,N),(X>N -> M=X; M=N).

%-------------------------------------------------------------------------------------------------------------

%H) Construa o predicado media(L,X), onde X é o valor médio dos valores contidos na lista L.
tamanho([],0).
tamanho([_|R],N):- tamanho(R,N1), N is N1 + 1.

media([],0).
media([X|Y],S):- soma([X|Y],W),
                 tamanho([X|Y],Z),
                 S is W / Z.

%------------------------------------------------------------------------------------------------------------

%I) Construa o predicado escore(X,Y,A,B) onde X e Y são listas de inteiros do mesmo tamanho, A é o número de posições que possuem números idênticos e B é o número de elementos que ocorrem simultaneamente em ambas as listas, mas em posições diferentes.




%------------------------------------------------------------------------------------------------------------

%J)Construa o predicado palindromo(X) que é verdadeiro se X é uma lista cujos elementos invertidos produzem a mesma ordem original.

conc([],L,L).
conc([X|L1],L2,[X|L3]):- conc(L1,L2,L3).

inverter([],[]).
inverter([X|Y],Z):- inverter(Y,Y1),
                    conc(Y1,[X],Z).
                    
palindrome([X|Y],S):-  inverter([X|Y],A),
                       inverter(A,B),
                       S = true -> A==B.

%-------------------------------------------------------------------------------------------------------------


%Resoluções
%A)  listaA(10,X).
%B)  listaB(2,9,L).
%C)  soma([1,2,3,4,5],X).
%D)  par(2).
%E)  lista_pares(10,X).
%F)  ultimo([1,2,3,4,5],X).
%G)  maiorElemento([1,2,10,4,5],X).
%H)  media([1,2,3],X).
%I)
%J)  palindrome([1,2,1],X).




