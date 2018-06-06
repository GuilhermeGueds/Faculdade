
% Autor: Guilherme Guedes
% Data: 16/05/2018
% Exercicio 1

%--------------------------------------------------
% A)
fatorial(0,1).
fatorial(N,F) :-
   N>0,
   N1 is N-1,
   fatorial(N1,F1),
   F is N * F1.
   
   % fatorial(1,X).
%--------------------------------------------------

%-------------------------------------------------
% B)

fib(0,1).
fib(1,1) .
fib(N,NF):- N > 1,
            A is N -1, B is N -2,
            fib(A,AF),fib(B,BF),
            NF is AF + BF.


% fib(10,X).

%----------------------------------------------------

%Resoluçao

%A)  fatorial(1,X).
%B)  fib(10,X).