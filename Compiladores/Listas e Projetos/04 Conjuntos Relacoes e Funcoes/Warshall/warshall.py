# funcoes
def warshall(a, n):
    w = a.copy()

    for i in range(n):
        for j in range(n):
            w[i][j] = a[i][j]
    
    for k in range(n):
        for i in range(n):
            for j in range(n):
                w[i][j] = w[i][j] or (w[i][k] and w[k][j])

    return w

def alcanca(a, n, v1, v2):
    '''
    Os parametros "v1" e "v2" sao os valores dos vertices.
    Subtraimos 1 para pegarmos o indice correspondente na matriz de warshall
    '''
    w = warshall(a, n)
    return bool(w[v1-1][v2-1])

def exibirMatriz(m):
    for line in m:
        print(line)

# corpo
adjacencia = [[1, 1, 0, 0],
              [0, 0, 0, 1],
              [1, 0, 1, 0],
              [0, 1, 0, 1]]; 

numVertices = 4

matWarshall = warshall(adjacencia, numVertices)

exibirMatriz(matWarshall)

chega = alcanca(adjacencia, numVertices, 1, 1)
print(chega)
chega = alcanca(adjacencia, numVertices, 1, 2)
print(chega)
chega = alcanca(adjacencia, numVertices, 1, 3)
print(chega)