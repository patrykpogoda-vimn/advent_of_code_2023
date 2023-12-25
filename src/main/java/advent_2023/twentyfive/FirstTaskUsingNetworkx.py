import networkx as nx

lines = open('input.txt').read().splitlines()
node_tuples = []

for line in lines:
    parts = line.split(": ")
    name = parts[0]
    neighbours = parts[1].split(" ")
    for neighbour in neighbours:
        node_tuples.append((name, neighbour))

graph = nx.Graph()
graph.add_edges_from(node_tuples)
cut = nx.minimum_edge_cut(graph)

if len(cut) != 3:
    raise Exception("Not three edges in cut")

graph.remove_edges_from(cut)

connectedComponents = list(nx.connected_components(graph))

connectedLen = len(connectedComponents)

if connectedLen != 2:
    raise Exception("Not two connected components")

firstLen = len(connectedComponents[0])
secondLen = len(connectedComponents[1])

print(firstLen * secondLen)