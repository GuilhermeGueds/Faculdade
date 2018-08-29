import networkx as nx
import matplotlib.pyplot as plt




G = nx.Graph()

'''g.add_node(2)
g.add_node(5)

g.add_edge(2,5)
g.add_edge(4,1)
g.add_edges_from()
#g.add_edges_from([(2,5),(1,3)])
print(nx.info(g))'''

'''G.add_edge(1, 2, weight=1 )
G.add_edges_from([(3, 4), (4, 5)], color='red')
G.add_edges_from([(1, 2, {'color': 'blue'}), (2, 3, {'weight': 8})])
G[1][2]['weight'] = 1
G.edges[3, 4]['weight'] = 1'''

DG = nx.DiGraph()
DG.add_weighted_edges_from([(1, 2, 0.5), (3, 1, 0.75)])
DG.out_degree(1, weight='weight')
0.5
DG.degree(1, weight='weight')
1.25
list(DG.successors(1))
[2]
list(DG.neighbors(1))
[2]


nx.draw_networkx(G)
plt.show()
