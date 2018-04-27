


Ab = input("Entre com a matriz : ");

disp("entrada")
disp(Ab)

n = size(Ab,1)

// Determina a triangulação superior
for j = 1: (n-1)
    for i = (j+1):n
          //verifica se a diogonal não possui 0
        if  (Ab(j,j)== 0) then
             y=Ab(1,:)
             Ab(1,:)=Ab(2,:)
             Ab(2,:)=y      
            end 
        m(i,j) = Ab(i,j)/Ab(j,j);
        Ab(i,:) = m(i,j) * Ab(j,:) - Ab(i,:)
         disp(Ab)
    end 
end

// Determina a triangulação Gaus&Jordan
for j = n: -1:1
   for i = (j-1):-1:1
         //verifica se a diogonal não possui 0
        if  (Ab(j,j)== 0) then
             y=Ab(1,:)
             Ab(n,:)=Ab(n-1,:)
             Ab(n-1,:)=y      
            end 
        m(i,j) = Ab(i,j)/Ab(j,j);
        Ab(i,:) = m(i,j) * Ab(j,:) - Ab(i,:)
        disp(Ab)
    end 
end

disp("Metodo Gaus&Jordan")
disp(Ab)

 //Faz divisao de A e B para encontrar resultado
for i = 1:n
    for j = 1:n
         A(i,j)= Ab(i,j)
         B(i,1)= Ab(i,(n+1))
    end
end

disp("Resultado final")
C= rref([A,B]);disp(C)
