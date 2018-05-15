//Interpolação Quadratica

clear
clc

x = [-1;0;2];
y = [4;1;-1];

n = size(x,1)

A = [x^2 x ones(n,1)]
Ab = [A y]
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

//interpolação quadratica
x= [];
x(n) = Ab(n,n+1)/Ab(n,n);

for i = (n-1):-1:1
    x(i,1) = (Ab(i,n+1)-Ab(i,(i+1:n))*x((i+1:n),1))/Ab(i,i);
end
//y = x(1,1)*0.3+x(2,1)
disp("x =")
disp(x)
