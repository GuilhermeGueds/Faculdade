% Autor: Guilherme Guedes
% Data: 16/05/2018
% Exercicio 3


%A) lista([a,[b],c,[d]]) = lista([_|[X|X]]).     ->        false.

%B) lista([[a],[b],C])=lista([C,B,[a]]).         ->        C = [a] , B = [b]

%C) lista([c,c,c])=lista([X|[X|_]]).             ->        X = c

%D) lista([a,[b,c]])=lista([A,B,C]).             ->        false

%E) [1,2,3,4,5,6,7]=[X,Y,Z|D].                   ->        X = 1, Y = 2, Z = 3, D = [4,5,6,7]