import cv2

def Limiarizacao(fotoOriginal):

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

    cv2.imwrite(".\imagens\Limiarizacao.jpg", foto)  # salva imagem

    cv2.imshow("Imagem", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return foto
