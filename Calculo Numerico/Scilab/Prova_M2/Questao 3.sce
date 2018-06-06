clear
clc

function s = Ordem(x,y)    // Função para achar a ordem
    nPontos = length(x)
    T = zeros(nPontos,nPontos)
    T(:,1) = y;
    
    for j = 2:nPontos
        for i = 1:(nPontos - j + 1)
            T(i,j) = (T(i+1,j-1) - T(i,j-1)) / (x(j + i-1) - x(i))
        end
    end
     
    for i = 1:nPontos
         printf('\n\n\n')
        for j = 1:(nPontos)
            if(T(i,j)<>0)then           
                 printf('%f     ' ,T(i,j));
            end
        end
    end
    disp("----------------------------------------------------------","")
    //disp(T)
    s = T(1,:);
endfunction

function y = P(A,x,Ordem)   // Obter o f(x) Apartier de um ponto 
    y = Ordem(1)
    
    for i=2:length(Ordem)
        produto = Ordem(i);
        
        for j=1:i-1
            produto = produto*(A-x(j))
        end
        y = y+produto
    end
endfunction

function e = EstimarErro(x,A,ordem)     // Obter estimativa para erro
        n = length(x) 
        erro =1
        for i=1:n
            erro = abs( erro * (A-x(i))     )        
        end
        e = abs(erro*ordem)
endfunction
//-----------------------------------------------------------------------------
x = [55,70,85,100,115,130]       //x
y = [14.08,13.56,13.28,12.27,11.30,10.40]    //f(x)
A = 90                              //ponto para achar
p = poly(0,'x')
//------------------------------------------------------------------------------
printf(" Ordem Completa:") 
ordem = Ordem(x,y)          // acha as ordens
//------------------------------------------------------------------------------
x = [70,85,100]       //x
y = [13.56,13.28,12.27]    //f(x)
n = -1 + length(x)
printf(" Ordem: %d",n) 
ordem = Ordem(x,y)          // acha as ordens
//------------------------------------------------------------------------------




polinomio = P(p,x,ordem)                // calcula f(x) em forma de polinomio
disp(polinomio,'Polinomio:')
disp('')
resultado = P(A,x,ordem)                // calcula f(x) no ponto escolhido
//-----------------------------------------------------------------------------
disp('Resultado:')
printf('     f(%.2f) = %f',A,resultado)
disp('')
//-----------------------------------------------------------------------------

