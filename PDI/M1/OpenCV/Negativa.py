import cv2

def Negativa(fotoOriginal):

    foto = fotoOriginal

    for i in range(foto.shape[0]):
        for j in range(foto.shape[1]):
            r = 255 - foto.item(i, j, 2)
            g = 255 - foto.item(i, j, 1)
            b = 255 - foto.item(i, j, 0)



            foto.itemset((i, j, 2), r)
            foto.itemset((i, j, 1), g)  # modificando a cor de um pixel
            foto.itemset((i, j, 0), b)

    cv2.imwrite(".\imagens/Negativa.jpg", foto)  # salva imagem

    cv2.imshow("Imagem", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return foto
