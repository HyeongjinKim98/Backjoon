N = int(input())
T = list(map(int, input().split()))
stack = []
res = [0]*N
for i in range(N):
    while stack:
        if T[stack[-1][0]]<T[i]:
            stack.pop()
        else:
            res[i] = stack[-1][0]+1
            break
    stack.append((i,T[i]))
print(*res)