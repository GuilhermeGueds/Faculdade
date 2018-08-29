import cv2
import matplotlib.pyplot as plt


def grafico(red, green, blue):

    plt.rcParams['figure.figsize'] = (19.20, 10.5)
    plt.title('Histograma')  # adicionando o título
    plt.xlabel('Pixel')
    plt.ylabel('Quantidade')

    plt.plot(red, color='red')
    plt.plot(green, color='green')
    plt.plot(blue, color='blue')
    plt.show()

    plt.savefig('.\imagens\Histograma.png', transparent = True)



def Histograma(fotoOriginal):

    foto = fotoOriginal

    red = []
    green = []
    blue = []
    for k in range(256):
        red.append(0)
        green.append(0)
        blue.append(0)

    for i in range(foto.shape[0]):
        for j in range(foto.shape[1]):
            r = foto.item(i, j, 2)
            g = foto.item(i, j, 1)
            b = foto.item(i, j, 0)

            red[r] = red[r] + 1
            green[g] =  green[g] + 1
            blue[b] = blue[b] + 1

    grafico(red,green, blue)

