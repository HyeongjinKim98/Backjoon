from collections import deque

n,k = map(int, input().split())
queue = deque()
jp =[]
for i in range(1, n+1):
    queue.append(i)

while queue:
    for i in range(k - 1):
        queue.append(queue.popleft())
    jp.append(queue.popleft())

print('<',end='')
for i in range(len(jp)-1):
    print("%d, "%jp[i], end='')
print(jp[-1],end='')
print('>',end='')
