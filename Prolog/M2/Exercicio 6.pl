% Autor: Guilherme Guedes
% Data: 16/05/2018
% Exercicio 6

% Explique a fun��o dos �cuts� inclu�dos no programa abaixo.

 imaturo(X):- adulto(X), !, fail.                  % RESPOSTA:  Aqui o cut serve como o Not, se X adulto entao n�o � imaturo, se nao � imaturo.
 imaturo(X).
 adulto(X):- pessoa(X), !, idade(X, N), N>=18.      % Aqui o cut ele evita passar para a proxima linha de codigo se a condi��o for verdadeira Ex: se X for pessoa verifica sera adulto se N >= 18 e encerra....
 adulto(X):- tartaruga(X), !, idade(X, N), N>=50.   % e se x n�o for uma pessoa dai sim verifica se ele � uma tartaruga, sera uma tartaruga adulta se N >=50.
 

