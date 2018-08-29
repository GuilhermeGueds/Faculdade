from Bilioteca import BConversaoSimples
import cv2


def Convolucao(fotoOriginal):

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



    cv2.imwrite(".\imagens\Convolucao.jpg", foto)  # salva imagem

    cv2.imshow("Convolucao", foto)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

    return foto