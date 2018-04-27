% Autor:  GUilherme Guedes
% Data: 17/03/2018

% cons(X,Y,[X|Y]).

% membro(X,[X|_]),!.
% membro(X,[_|C]):- membro(X,C),!.

conc([],L,L).
conc([X|L1],L2,[X|L3]):- conc(L1,L2,L3).
% comando conc(L1,L2,[1,2,3,4]).