import cv2

def Adicao(fotoOriginal,foto2Original):

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

    cv2.imwrite(".\imagens\Adicao.jpg", foto)  # salva imagem

    cv2.imshow("Imagem", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return foto


def Subtracao(fotoOriginal, foto2Original):

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

    cv2.imwrite(".\imagens\Subtracao.jpg", foto)  # salva imagem

    cv2.imshow("Imagem", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return foto
