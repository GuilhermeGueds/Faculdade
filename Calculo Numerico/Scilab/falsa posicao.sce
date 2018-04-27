clc
clear
disp("falsa posição")
disp("")

function [s] = f(x)
    s = (2*cos(x)-(%e^x)/2)
endfunction
a=-1;
b=2;
x = 0;
e = 0.01;
k =1;


  x = ((a*f(b))-(b*f(a)))/(f(b)-f(a))
printf(' interaçoes: %d\n', k);
printf(' a: %f\n', a);
printf(' b: %f\n', b);
printf(' x: %f\n', x);
  disp("--------------------------------------------")    
while abs(b-a) >e & abs(f(x))>e
    x = ((a*f(b))-(b*f(a)))/(f(b)-f(a))
    if f(x) == 0;
        break;
    else
        if (f(a)* f(x)) > 0
            a = x;
         else
             b = x;
     end 
 end 
   x = ((a*f(b))-(b*f(a)))/(f(b)-f(a))  
  k = k + 1; 
printf(' interaçoes: %d\n', k);
printf(' a: %f\n', a);
printf(' b: %f\n', b);
printf(' x: %f\n', x);
  disp("--------------------------------------------")          
end

 printf('resultado x: %f\n', x);
 printf('interaçoes: %d\n', k);
 printf('resultado x: %f\n', x);
 printf('resultado (b-a): %f\n', (b-a));
 printf('resultado f(x): %f\n', abs(f(x)));
