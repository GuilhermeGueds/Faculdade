
function [s] = f(x)
    s = (%e^x - sin(x))
endfunction
a=-2.5;
b=-3.5;
x = 0;
e = 0.01;
k =0;

x = (a+b)/2

printf(' interaçoes: %d\n', k);
printf(' a: %f\n', a);
printf(' b: %f\n', b);
printf(' x: %f\n', x);
  disp("--------------------------------------------")
while abs(b-a) >e & abs(f(x))>e
    
   
    if f(x) == 0;
        break;
    else
        if (f(a)* f(x)) > 0
            a = x;
         else
             b = x;
     end 
 end   
  x = (a+b)/2
  k = k + 1;   
  printf(' interaçoes: %d\n', k);
printf(' a: %f\n', a);
printf(' b: %f\n', b);
printf(' x: %f\n', x);
  disp("--------------------------------------------")    
end
 printf('interaçoes: %d\n', k);
 printf('resultado x: %f\n', x);
 printf('resultado (b-a): %f\n', (b-a));
 printf('resultado f(x): %f\n', abs(f(x)));


