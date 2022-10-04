import sys
input=sys.stdin.readline

n=int(input())
li = []
for _ in range(0,n):
    li.append(int(input()))
li.sort()
for i in range(0,n):
    print(li[i])