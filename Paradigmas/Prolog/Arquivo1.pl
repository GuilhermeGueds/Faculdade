% Autor: Guilherme
% Data: 22/02/2018

soma(X,Y,Z):- Z is X+Y.
maior(X,Y,Z):-X>Y,Z is X,!.
par(X):- X mod 2=:= 0.
impar(X):-not(par(X)).
