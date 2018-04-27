
function [s] = f(x)
    s = x^3-10;
endfunction
a=2;
b=3;
x = 0;
e = 0.1;
k =0;

while abs(b-a) >e & abs(f(x))>e
    x = (a+b)/2
    if f(x) == 0;
        break;
    else
        if (f(a)* f(x)) > 0
            a = x;
         else
             b = x;
     end 
 end   
  k = k + 1;       
end

disp(x)
disp(k)
