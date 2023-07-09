from collections import deque

N = int(input())
M = [list(input()) for _ in range(N)]
q = deque()

res1 = 0
res2 = 0
def bfs(x,y):
    q.append((x,y))
    dx = [-1,0,1,0]
    dy = [0,1,0,-1]
    visited[x][y] = [True]
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0 <= nx < N and 0 <= ny < N and M[nx][ny] == M[x][y] and not visited[nx][ny]:
                visited[nx][ny] = 1
                q.append((nx, ny))

#색약x
visited =[[0]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i,j)
            res1 +=1

#색약o
visited =[[0]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if M[i][j] =="G":
            M[i][j] ="R"
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            bfs(i,j)
            res2 +=1

print(res1,res2)