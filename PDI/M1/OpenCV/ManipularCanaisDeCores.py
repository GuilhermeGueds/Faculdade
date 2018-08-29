import cv2


def IsolarCanaisDeCores(fotoOriginal,canal):

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

    if canal == 0:
        cv2.imwrite(".\imagens\Vermelho Isolado.jpg", foto)  # salva imagem
    elif canal == 1:
        cv2.imwrite(".\imagens\Verde Isoladdo.jpg", foto)  # salva imagem
    else:
        cv2.imwrite(".\imagens\Azul Isolado.jpg", foto)  # salva imagem

    cv2.imshow("Isolar Canais De Cores", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return foto

def IncrementarCanaisDeCores(fotoOriginal,canal,valor):

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


    if canal == 0:
        cv2.imwrite(".\imagens\Vermelho Incrementado.jpg", foto)  # salva imagem
    elif canal == 1:
        cv2.imwrite(".\imagens\Verde Incrementado.jpg", foto)  # salva imagem
    else:
        cv2.imwrite(".\imagens\Azul Incrementado.jpg", foto)  # salva imagem


    cv2.imshow("Incrementar Canais De Cores", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return foto