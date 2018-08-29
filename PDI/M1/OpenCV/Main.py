import cv2
from TonsDeCinza import *
from Negativa import *
from Limiarização import *
from Aritmeticas import *
from Convolucao import *
from ManipularCanaisDeCores import *
from Histograma import *
from Zoom import *
from Morfologia import *
from Bilioteca import *
from Camera import  *

foto = cv2.imread(".\imagens\Original/foto1.jpg",1)  # carrega imagem
foto2 = cv2.imread(".\imagens\Original/foto2.jpg",1)  # carrega imagem
foto3 = cv2.imread(".\imagens/Original/foto3.jpg",1)  # carrega imagem

#ConversaoSimples(foto)
#ConversaoPonderada(foto)
#Negativa(foto)
#Limiarizacao(foto)
#Adicao(foto,foto3)
#Subtracao(foto,foto2)
#Convolucao(foto)
#IsolarCanaisDeCores(foto,0)     # 2 = Red, 1 = Green, 0 = Blue
#IncrementarCanaisDeCores(foto,2,50)  # 2 = Red, 1 = Green, 0 = Blue
#Histograma(foto2)
#ZoomIn(foto)
#ZoomOut(foto)
#Dilatacao(foto)
#Erosao(foto)
#Abertura(foto)
#Fechamento(foto)

WebCam(BConvolucao)