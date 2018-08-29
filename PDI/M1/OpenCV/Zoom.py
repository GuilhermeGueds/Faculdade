
import numpy
import cv2


def ZoomIn(foto):

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

    cv2.imwrite(".\imagens\ZoomIn2.jpg", fotoAumentada)  # salva imagem

    cv2.imshow("Zoom In", fotoAumentada)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return fotoAumentada

def ZoomOut(foto):

    fotoAumentada = numpy.zeros((int(foto.shape[0]/2),int(foto.shape[1]/2),3), numpy.uint8)

    for i in range(0,foto.shape[0]-2,2):
        for j in range(0,foto.shape[1]-2,2):
            totalr = (foto.item(i, j, 2) + foto.item(i+1, j, 2) + foto.item(i, j+1, 2) + foto.item(i+1, j+1, 2))/4
            totalg = (foto.item(i, j, 1) + foto.item(i+1, j, 1) + foto.item(i, j+1, 1) + foto.item(i+1, j+1, 1))/4
            totalb = (foto.item(i, j, 0) + foto.item(i+1, j, 0) + foto.item(i, j+1, 0) + foto.item(i+1, j+1, 0))/4


            fotoAumentada.itemset((int(i/2), int(j/2), 2), totalr)
            fotoAumentada.itemset((int(i/2), int(j/2), 1), totalg)
            fotoAumentada.itemset((int(i/2), int(j/2), 0), totalb)



    cv2.imwrite(".\imagens\Convolucao.jpg", fotoAumentada)  # salva imagem

    cv2.imshow("Zoom In", fotoAumentada)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return fotoAumentada

