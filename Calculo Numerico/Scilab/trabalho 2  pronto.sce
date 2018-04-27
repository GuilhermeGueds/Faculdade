for x = 1:10

   disp("Quando x for igual = " + string (x))

    pf2 = (3 * x + 1)*1.60
    pf1 = 2 * pf2
    pf3 = 1.5 * pf1
    pf4 = pf2 + 12

    disp("O valor da fonte 1 sera = "+ string (pf1))
    disp("O valor da fonte 2 sera = "+ string (pf2))
    disp("O valor da fonte 3 sera = "+ string (pf3))
    disp("O valor da fonte 4 sera = "+ string (pf4))

    A= [pf1 pf2 pf3 pf4 ; 1 1 1 1 ; 1 1 0 0 ; 0 1 -1 0]
    B= [12620 ; 500 ; 400 ; 200]

   disp("Matriz A =" );disp(A)

   disp("vetor B =");disp(B)

   C= rref([A B]);disp(C)

   D=  A\B
  
   disp("resultado");disp (D)

    if D > 0 then
        fonte1=D(1)
        fonte2=D(2)
        fonte3=D(3)
        fonte4=D(4)
        x1=x
     end
end
disp("fim")

disp ("unico resultado real e positiva é quando x = " +string(x1))

disp("quantidade de fontes vendidas no mes é :")

disp ("Fonte 220V/9V     - 2 A = " +string(fonte1))

disp ("Fonte 110-220/12V - 0,5 = " +string(fonte2))

disp ("Fonte 110/220/12  - 2 A = " +string(fonte3))

disp ("Fonte 220V/6V     - 1 A = " +string(fonte4))
