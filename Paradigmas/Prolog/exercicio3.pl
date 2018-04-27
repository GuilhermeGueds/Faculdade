% Autor: Guilherme Guedes
% Data: 16/03/2018

  aluno(joao,paradigmas).
  aluno(maria,paradigmas).
  aluno(joel,lab2).
  aluno(joel,estruturas).
  frequenta(joao,feup).
  frequenta(maria,feup).
  frequenta(joel,ist).
  professor(carlos,paradigmas).
  professor(ana_paula,estruturas).
  professor(pedro,lab2).
  funcionario(pedro,ist).
  funcionario(ana_paula,feup).
  funcionario(carlos,feup).
  
  aluno_do_professor(X,Y):- professor(X,Z), aluno(Y,Z).

  pessoas_da_universidade(X,Y):-frequenta(X,Y);funcionario(X,Y).

  colegas(X,Y):- frequenta(X,Z),frequenta(Y,Z);
                 aluno(X,Z),aluno(Y,Z);
                 funcionario(X,Z),funcionario(Y,Z).
