import sys

n,k=map(int, sys.stdin.readline().split())

wallet = [int(sys.stdin.readline()) for _ in range(n)]
wallet = sorted(wallet,reverse=True)
cnt = 0

for money in wallet:
    if k//money>0 :
        cnt += k//money
        k  = k%money

    if k ==0 :
        break
print(cnt)
