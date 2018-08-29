import cv2
import numpy
from Histograma import  grafico
import matplotlib.pyplot as plt


def BLimiarizacao(fotoOriginal):

    foto = fotoOriginal
    for i in range(foto.shape[0]):
        for j in range(foto.shape[1]):
            r = foto.item(i, j, 2)
            g = foto.item(i, j, 1)
            b = foto.item(i, j, 0)
            if (r + g + b) / 3 > 127.5:
                t = 255
            else:
                t = 0
            foto.itemset((i, j, 2), t)
            foto.itemset((i, j, 1), t)  # modificando a cor de um pixel
            foto.itemset((i, j, 0), t)
    return foto

def BConversaoSimples(fotoOriginal):
    foto = fotoOriginal
    for i in range(foto.shape[0]):
        for j in range(foto.shape[1]):
            r = foto.item(i, j, 2)
            g = foto.item(i, j, 1)
            b = foto.item(i, j, 0)
            t = (r + g + b) / 3
            foto.itemset((i, j, 2), t)
            foto.itemset((i, j, 1), t)  # modificando a cor de um pixel
            foto.itemset((i, j, 0), t)
    return foto

def BDilatacao(foto):
    hotSpot =  [1,1]
    mascara = [[0, 1, 0],
               [1, 1, 1],
               [0, 1, 0]]
    fotoDelatada = numpy.zeros((int(foto.shape[0]), int(foto.shape[1]), 3), numpy.uint8)
    foto = BLimiarizacao(foto)
    for i in range( foto.shape[0]-2):
        for j in range(foto.shape[1]-2):

            if foto.item(i + hotSpot[0], j + hotSpot[1], 2) == 255:
                for c in range(3):
                    for l in range(3):
                        if mascara[c][l] == 1:
                            fotoDelatada.itemset((i+c , j+l , 2), 255)
                            fotoDelatada.itemset((i+c , j+l , 1), 255)  # modificando a cor de um pixel
                            fotoDelatada.itemset((i+c , j+l , 0), 255)
    return fotoDelatada

def BErosao(foto):
    hotSpot =  [1,1]
    mascara = [[0, 1, 0],
               [1, 1, 1],
               [0, 1, 0]]
    fotoDelatada = numpy.zeros((int(foto.shape[0]), int(foto.shape[1]), 3), numpy.uint8)
    foto = BLimiarizacao(foto)
    for i in range( foto.shape[0]-2):
        for j in range(foto.shape[1]-2):
            trava = True
            for c in range(3):
                for l in range(3):
                    if mascara[c][l] == 1 and foto.item(i+c, j+l, 0) != 255:
                        trava = False
            if trava == True:
                #print("yyyyyyyyyyyyy")
                fotoDelatada.itemset((i + hotSpot[0], j + hotSpot[1], 2), 255)
                fotoDelatada.itemset((i + hotSpot[0], j + hotSpot[1], 1), 255)  # modificando a cor de um pixel
                fotoDelatada.itemset((i + hotSpot[0], j + hotSpot[1], 0), 255)

    return fotoDelatada

def BConvolucao(fotoOriginal):

    mascara = [[-1, -1, -1], [-1, 8, -1], [-1, -1, -1]]

    total = 0
    foto = BConversaoSimples(fotoOriginal)

    for i in range( foto.shape[0]-2):
        for j in range(foto.shape[1]-2):

            for c in range(3):
                for l in range(3):
                    total = total + mascara[l][c] * foto.item((i + c), (j + l), 2)

            if total > 255:
                total = 255
            if total < 0:
                 total = 0

            foto.itemset((i-1, j-1, 2), total)
            foto.itemset((i-1, j-1, 1), total)  # modificando a cor de um pixel
            foto.itemset((i-1, j-1, 0), total)
            total = 0

    return foto

def BAdicao(fotoOriginal,foto2Original):

    foto = fotoOriginal
    foto2 = foto2Original

    if foto.shape[0] < foto2.shape[0]:
        z = foto.shape[0]
    else:
        z = foto2.shape[0]

    if foto.shape[1] < foto2.shape[1]:
        w = foto.shape[1]
    else:
        w = foto2.shape[1]

    for i in range(z):
        for j in range(w):
            r = foto.item(i, j, 2)
            g = foto.item(i, j, 1)
            b = foto.item(i, j, 0)
            p = (r+g+b)/3

            r2 = foto2.item(i, j, 2)
            g2 = foto2.item(i, j, 1)
            b2 = foto2.item(i, j, 0)
            p2 = (r+g+b)/3

            foto.itemset((i, j, 2), (r + r2)/2)
            foto.itemset((i, j, 1), (g + g2)/2)  # modificando a cor de um pixel
            foto.itemset((i, j, 0), (b + b2)/2)


    return foto

def BSubtracao(fotoOriginal, foto2Original):

    foto = fotoOriginal
    foto2 = foto2Original

    if foto.shape[0] < foto2.shape[0]:
        z = foto.shape[0]
    else:
        z = foto2.shape[0]

    if foto.shape[1] < foto2.shape[1]:
        w = foto.shape[1]
    else:
        w = foto2.shape[1]

    for i in range(z):
        for j in range(w):
            r = foto.item(i, j, 2)
            g = foto.item(i, j, 1)
            b = foto.item(i, j, 0)


            r2 = foto2.item(i, j, 2)
            g2 = foto2.item(i, j, 1)
            b2 = foto2.item(i, j, 0)

            rt = r - r2
            gt = g - g2
            bt = b - b2

            if rt < 0:
                rt= rt * -1
            if gt < 0:
                gt= gt * -1
            if bt < 0:
                bt= bt * -1

            foto.itemset((i, j, 2), rt)
            foto.itemset((i, j, 1), gt )  # modificando a cor de um pixel
            foto.itemset((i, j, 0), bt )

    return foto

def BHistograma(fotoOriginal):

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

def BIsolarCanaisDeCores(fotoOriginal,canal):

    foto = fotoOriginal
    for i in range(foto.shape[0]):
        for j in range(foto.shape[1]):

            if canal == 0:
                foto.itemset((i,j,2),0)
                foto.itemset((i,j,1),0)
            elif canal == 1:
                foto.itemset((i, j, 2), 0)
                foto.itemset((i, j, 0), 0)
            else:
                foto.itemset((i, j, 1), 0)
                foto.itemset((i, j, 0), 0)

    return foto

def BIncrementarCanaisDeCores(fotoOriginal,canal,valor):

    foto = fotoOriginal

    for i in range(foto.shape[0]):
        for j in range(foto.shape[1]):

            if canal == 0:
                if foto.item(i,j,0) + valor > 255:
                    foto.itemset((i,j,0),255)
                else:
                    foto.itemset( (i, j, 0), foto.item(i,j,0) + valor)

            elif canal == 1:
                if foto.item(i,j,1) + valor > 255:
                    foto.itemset((i,j,1),255)
                else:
                    foto.itemset(  (i, j, 1), foto.item(i,j,1) + valor)
            else:
                if foto.item(i,j,2) + valor > 255:
                    foto.itemset((i,j,2),255)
                else:
                    foto.itemset( (i, j, 2), foto.item(i,j,2) + valor)

    return foto

def BNegativa(fotoOriginal):

    foto = fotoOriginal

    for i in range(foto.shape[0]):
        for j in range(foto.shape[1]):
            r = 255 - foto.item(i, j, 2)
            g = 255 - foto.item(i, j, 1)
            b = 255 - foto.item(i, j, 0)



            foto.itemset((i, j, 2), r)
            foto.itemset((i, j, 1), g)  # modificando a cor de um pixel
            foto.itemset((i, j, 0), b)

    return foto

def BZoomIn(foto):

    fotoAumentada = numpy.zeros((foto.shape[0]*2,foto.shape[1]*2,3), numpy.uint8)

    for i in range(foto.shape[0]):
        for j in range(foto.shape[1]):
            r = foto.item(i, j, 2)
            g = foto.item(i, j, 1)
            b = foto.item(i, j, 0)

            fotoAumentada.itemset((i*2, j*2, 2), r)
            fotoAumentada.itemset((i*2, j*2, 1), g)
            fotoAumentada.itemset((i*2, j*2, 0), b)

            fotoAumentada.itemset((i*2+1, j*2+1, 2), r)
            fotoAumentada.itemset((i*2+1, j*2+1, 1), g)
            fotoAumentada.itemset((i*2+1, j*2+1, 0), b)

            fotoAumentada.itemset((i * 2 , j * 2 + 1, 2), r)
            fotoAumentada.itemset((i * 2 , j * 2 + 1, 1), g)
            fotoAumentada.itemset((i * 2 , j * 2 + 1, 0), b)

            fotoAumentada.itemset((i * 2 + 1, j * 2 , 2), r)
            fotoAumentada.itemset((i * 2 + 1, j * 2 , 1), g)
            fotoAumentada.itemset((i * 2 + 1, j * 2 , 0), b)

    return fotoAumentada

def BZoomOut(foto):

    fotoAumentada = numpy.zeros((int(foto.shape[0]/2),int(foto.shape[1]/2),3), numpy.uint8)

    for i in range(0,foto.shape[0]-2,2):
        for j in range(0,foto.shape[1]-2,2):
            totalr = (foto.item(i, j, 2) + foto.item(i+1, j, 2) + foto.item(i, j+1, 2) + foto.item(i+1, j+1, 2))/4
            totalg = (foto.item(i, j, 1) + foto.item(i+1, j, 1) + foto.item(i, j+1, 1) + foto.item(i+1, j+1, 1))/4
            totalb = (foto.item(i, j, 0) + foto.item(i+1, j, 0) + foto.item(i, j+1, 0) + foto.item(i+1, j+1, 0))/4


            fotoAumentada.itemset((int(i/2), int(j/2), 2), totalr)
            fotoAumentada.itemset((int(i/2), int(j/2), 1), totalg)
            fotoAumentada.itemset((int(i/2), int(j/2), 0), totalb)

    return fotoAumentada
