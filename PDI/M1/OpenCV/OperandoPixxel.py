import cv2



foto = cv2.imread(".\imagens\Original\lenna.jpg",1)

print(foto.shape[0])    #altura,largura,canal de cores
print(foto.item(0,0,0),foto.item(0,0,1),foto.item(0,0,2))           #  altura,  largura,   bgr
x = foto[0,0]
print(x)
