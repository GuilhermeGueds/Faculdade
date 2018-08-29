import cv2
import numpy
from Bilioteca import BLimiarizacao, BDilatacao, BErosao

def Dilatacao(foto):
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


    cv2.imwrite(".\imagens\Dilatacao.jpg", fotoDelatada)  # salva imagem

    cv2.imshow("Dilatação", fotoDelatada)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return fotoDelatada


def Erosao(foto):
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

    cv2.imwrite(".\imagens\Erosao.jpg", fotoDelatada)  # salva imagem
    cv2.imshow("Erosao", fotoDelatada)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return fotoDelatada

def Abertura(foto):

    foto = BDilatacao(BErosao(foto))

    cv2.imwrite(".\imagens\Abertura.jpg", foto)  # salva imagem
    cv2.imshow("Abertura", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
    return foto


def Fechamento(foto):
    foto = BErosao(BDilatacao(foto))

    cv2.imwrite(".\imagens\Fechamento.jpg", foto)  # salva imagem
    cv2.imshow("Fechamento", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()
    return foto