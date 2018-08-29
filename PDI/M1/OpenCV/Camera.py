import cv2
from Bilioteca import *

import numpy as np

def WebCam(funcao):
    cap = cv2.VideoCapture(0)
    while(True):
        ret,frame = cap.read()
        go = funcao(frame)
        cv2.imshow("frame",go)
        cv2.waitKey(1)

    #cap.release()
   # cv2.destroyAllWindows()


def WebCam2(funcao,foto):
    cap = cv2.VideoCapture(0)

    while (True):
        ret, frame = cap.read()
        go = funcao(frame,foto)
        cv2.imshow("frame", go)
        cv2.waitKey(1)

    cap.release()
    cv2.destroyAllWindows()