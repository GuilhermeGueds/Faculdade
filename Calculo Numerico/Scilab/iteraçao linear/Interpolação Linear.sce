//Interpolação linear

clear
clc

x = [01;06];
y = [1.221;3.320];

n = size(x,1)

A = [x ones(n,1)]
Ab = [A,y]
disp(Ab)

// Determina a triangulação superior
for j = 1: (n-1)
    for i = (j+1):n
          //verifica se a diogonal não possui 0
        if  (Ab(j,j)== 0) then
             y=Ab(j,:)
             Ab(j,:)=Ab(j+1,:)
             Ab(j+1,:)=y      
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
// Até aqui o algoritmo chega na matriz triangular superior
// Falta fazer a retro substituição


disp("Matriz Triangular Ab = ")
disp(Ab)

x=[];
x(n)=Ab(n,n+1)/Ab(n,n); // Resolve o último valor de x

for i=(n-1):-1:1
    x(i,1)=(Ab(i,n+1)-Ab(i,(i+1:n))*x((i+1:n),1))/Ab(i,i);
end

disp("Matriz solução do sistema x = ")
disp(x)

z = 0.3

disp("Valor de y para x = 0.3")
y=x(1,1)*z+x(2,1)
disp(y)
