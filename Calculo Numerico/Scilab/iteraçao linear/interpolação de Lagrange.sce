clc
clear
function s = Lagrange(M,x)
    
    
    [m n] = size(M);
    s = zeros(1,length(x));
    for i = 1:n
        p = ones(1,length(x))
        for j = 1:n
            if i<>j then
                p = p * (x-M(1,j))/(M(1,i)-M(1,j));
            end
        end
        
        s = s + M(2,i)*p
    end
    s
endfunction
//Questao
A = [0,0.2,0.4,0.5;0,2.008,4.064,5.125]
B = [-1,0,2;4,1,-4]


x = poly(0,'x')
y = 0.3

p = Lagrange(A,x)
r = Lagrange(A,y)

disp (p,"polinomio:")
disp(r,"resultado:")

