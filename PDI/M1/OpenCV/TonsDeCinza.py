import cv2

def ConversaoSimples(fotoOriginal):

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

    cv2.imwrite(".\imagens\Conversao Simples.jpg", foto)  # salva imagem

    cv2.imshow("Imagem", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return foto

def ConversaoPonderada(fotoOriginal):

    foto = fotoOriginal

    for i in range(foto.shape[0]):
        for j in range(foto.shape[1]):
            r = foto.item(i, j, 2)
            g = foto.item(i, j, 1)
            b = foto.item(i, j, 0)

            t = r * 0.299 + g * 0.587 + b * 0.114

            foto.itemset((i, j, 2), t)
            foto.itemset((i, j, 1), t)  # modificando a cor de um pixel
            foto.itemset((i, j, 0), t)

    cv2.imwrite(".\imagens\Conversao Ponderada.jpg", foto)  # salva imagem

    cv2.imshow("Imagem", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return foto