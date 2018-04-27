% Autor:  Guilherme Guedes
% Data: 16/03/2018

  entrada(salada).
  entrada(pao).
  prato(peixe).
  prato(carne).
  prato(massa).
  sobremesa(sorvete).
  sobremesa(pudim).
  refeicao(A,B,C):- entrada(A),prato(B),sobremesa(C).
  
