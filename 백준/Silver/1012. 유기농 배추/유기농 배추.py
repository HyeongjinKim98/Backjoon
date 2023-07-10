## BFS

from collections import deque

# 방향 설정
dx = [0,1,0,-1]
dy = [-1,0,1,0]

def bfs(x,y):
    queue = [(x,y)]
    graph[x][y] =0 #방문

    while queue :
        x,y = queue.pop(0)
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= M or ny < 0 or ny >= N:
                continue #범위 밖일때 처리

            if graph[nx][ny] == 1: #인접해있을때
                queue.append((nx,ny))
                graph[nx][ny] = 0

for _ in range(int(input())):
    res = 0
    M, N, K = map(int,input().split())
    if M>=N :
        V= []
    graph = [[0 for _ in range(N)]for _ in range(M)]
    for _ in range(K):
        x,y = map(int,input().split())
        graph[x][y] = 1

    for i in range(M):
        for j in range(N):
            if graph[i][j] ==1 :
                bfs(i,j)
                res += 1
    print(res)

