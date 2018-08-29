
from Grafo import Grafo



def menu():
    entrada = 0
    while entrada < 1 or entrada >= 10 :
        entrada = int(input ("\n1 - inserir Vertice\n"
                          "2 - Inserir Aresta\n"
                          "3 - Remover Vertice\n"
                          "4 - Remover Aresta\n"
                          "5 - Verifica se Vertices são adjacentes\n"
                          "6 - Retorna elemento armazenado na aresta\n"
                          "7 - Retorna elemento armazenado no Vertice\n"
                          "8 - Retorna referencia para os 2 vertices finais da aresta\n"
                          "9 - Criar grafico\n"
                          "X - sair             -> "))
    return entrada


def Demonstracao1():

    grafo = Grafo()

    grafo.inserirVertice('A')
    grafo.inserirVertice('B')
    grafo.inserirVertice('C')
    grafo.inserirVertice('D')
    grafo.inserirVertice('E')
    grafo.inserirVertice('F')
    grafo.inserirVertice('G')
    grafo.inserirVertice('H')
    grafo.inserirVertice('I')
    grafo.inserirVertice('J')
    grafo.inserirVertice('K')
    grafo.inserirVertice('L')
    grafo.inserirVertice('M')
    grafo.inserirVertice('N')

    grafo.inseririAresta('A','B',10)
    grafo.inseririAresta('B','C',10)
    grafo.inseririAresta('C','D',10)
    grafo.inseririAresta('D','E',10)
    grafo.inseririAresta('E','F',10)
    grafo.inseririAresta('F','G',10)
    grafo.inseririAresta('G','H',10)
    grafo.inseririAresta('H','I',10)
    grafo.inseririAresta('I','J',10)
    grafo.inseririAresta('J','K',10)
    grafo.inseririAresta('K','L',10)
    grafo.inseririAresta('L','M',10)
    grafo.inseririAresta('M','N',10)
    grafo.inseririAresta('N','A',10)
    grafo.inseririAresta('A','L',10)
    grafo.inseririAresta('C','F',10)
    grafo.inseririAresta('F','J',10)
    grafo.inseririAresta('E','N',10)
    grafo.inseririAresta('H','L',10)
    grafo.inseririAresta('I','M',10)
    grafo.inseririAresta('D','L',10)

    grafo.mostrarTodasAresta()
    grafo.mostrarTodosOsVertices()
    grafo.criarGrafico()

