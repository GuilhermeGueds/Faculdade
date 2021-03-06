% Autor: Guilherme Guedes
% Data: 16/05/2018
% Exercicio 5

dados(um).
dados(dois).
dados(tres).

%---------------------------------------------------------------  --------------------
%A)  Qual o resultado da seguinte pergunta?
cut_teste_a(X) :- dados(X).
cut_teste_a('ultima_clausula').
% resolu��o ->  cut_teste_a(X), write(X), nl, fail.

%Resposta A) -> um, dois, tres, ultima_clausula,false

%-------------------------------------------------------------------------------------

%B)   Qual o resultado do seguinte programa com um Cut no final da primeira clausula?
cut_teste_b(X):- dados(X), !.
cut_teste_b('ultima_clausula').
% resolu��o -> cut_teste_b(X), write(X), nl, fail.

%Resposta B)-> um, false

%-------------------------------------------------------------------------------------

%C) Qual o resultado do seguinte programa com um Cut no meio dos dois objetivos?
cut_teste_c(X,Y) :- dados(X), !, dados(Y).
cut_teste_c('ultima_clausula').
% resolu��o -> cut_teste_c(X,Y), write(X-Y), nl, fail.

%Resposta C)-> um-um, um-dois, um-tres, false

%--------------------------------------------------------------------------------------