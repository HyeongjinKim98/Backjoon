import sys

n,m,b = map(int,sys.stdin.readline().split())
block = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
res = sys.maxsize
lev = 0

for h in range(257):
    rm_block = 0
    add_block = 0

    for i in range(n):
        for j in range(m):
            if block[i][j]>h :
                rm_block += block[i][j] - h
            else:
                add_block += h -block[i][j]

    if rm_block +b < add_block :
        continue

    sec = rm_block * 2 + add_block

    if sec <= res:
        res = sec
        lev = h

print(res, lev)