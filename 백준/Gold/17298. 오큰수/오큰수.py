N = int(input())
A = list(map(int,input().split()))
res = [-1]*N
stack = []
for i in range(N):
    while stack and A[stack[-1]] < A[i] :
        res[stack.pop()] = A[i]
    stack.append(i)
print(*res)
