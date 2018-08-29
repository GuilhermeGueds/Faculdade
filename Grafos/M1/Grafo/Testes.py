

'''x = []
i=0
x.append('a')
x.append('b')
x.append('c')
#print(x.__contains__())
#print (x[x.index('b')])

z =len(x)
for i in range(z):
    print(x[i])'''

'''x = []


x.append({0:'a',1:'b',2:100})
x.append({0:'a',1:'b','peso':1000})

x.pop(0)
print(x)'''

class Teste():
    __x= ''

    def print(self, kk):
        self.__x = kk
        print(self.__x)


x = Teste()
x.print("xxxxx")

del x
print(type(x))