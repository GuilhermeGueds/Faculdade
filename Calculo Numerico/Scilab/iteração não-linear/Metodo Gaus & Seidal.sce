MatrizA = []
MatrizB = []
MatrizC = []
controle = 0
controle2 = 0
validade = 0
/*
while(validade ~=1 )
    MatrizA = input("Entre com a matiz: ");
    MatrizB = input("Entre com os termos separados por ;: ");
    parada = input ("Entre com o ponto de parada: ");
    limite = input("Entre com o limite de interações:  ")

    disp('Matriz: ')
    disp(MatrizA)
    disp("------------------------------")
    disp('Interação 0: ')
    disp(MatrizB)
    disp("------------------------------")
    disp('Ponto de parada: ')
    disp(parada)
    disp("------------------------------")
    disp('limite de interações: ')
    disp(limite)
    disp("------------------------------")

    validade = input("Deseja efetuar os calculos 1-Sim | 0-Nao  :  ")
end

disp ("CALCULANDO.........")
disp("------------------------------")*/
MatrizA = [5,1,1,5;3,4,1,6;3,3,6,0]
MatrizB = [0;0;0]
//MatrizA = [2,-1,1;1,2,3]
//MatrizB = [0;0]
//MatrizA = [20,1,1,2,33;1,10,2,4,38.4;1,2,10,1,43.5;2,4,1,20,45.6]
//MatrizB = [0;0;0;0]
//MatrizA = [10,1,1,2,3,-2,6.57;4,-20,3,2,-1,7,-68.448;5,-3,15,-1,-4,1,-112.05;-1,1,2,8,-1,2,-3.968;1,2,1,3,9,-1,-2.18;-4,3,1,2,-1,12,10.882]
//MatrizB = [1;1;1;1;1;1]
parada = 0.05
limite = 10

n = size(MatrizA,1)

while((controle < n) && controle2 <= limite-1 )  
    controle = 0
    printf('interação: %d\n', controle2);
            disp(MatrizB)
    for i = 1: (n)
        x=0
        for j = 1: (n)
            if(i ~= j)
                x = x + (MatrizA(i,j)* MatrizB(j:j))
            end   
        end
         MatrizC = MatrizB      
         MatrizB(i:i) = (MatrizA(i,n+1) - x)/MatrizA(i,i)
          
    end
    
    for i = 1: (n)
        x =   MatrizB(i:i) - MatrizC(i:i)  
        
        if (x < 0)
            x = x * -1;
        end
        if(x < parada)
            controle = controle + 1;y
        else
        if(x > 0)
           
            disp("------------------------------")
            controle = 0
        end
        end
    end
     controle2 = controle2 + 1
end 
    disp("------------------------------")
    disp("Resultado final")  
    printf('\n interação: %d\n', controle2);
    disp(MatrizB)
