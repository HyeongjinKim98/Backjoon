import sys

n,m = map(int,sys.stdin.readline().split())

li = list(map(int,sys.stdin.readline().split()))
sum = [0]
for i in range(n):
    sum.append(sum[i]+li[i])

for _ in range(m):
    i,j =map(int,sys.stdin.readline().split())
    print(sum[j]-sum[i-1])
