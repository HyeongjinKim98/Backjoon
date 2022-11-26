import sys

n,m = map(int,sys.stdin.readline().split())
pokedict = {}
dictpoke = {}
for i in range(1,n+1):
    poke = sys.stdin.readline().strip()
    pokedict[i] = poke
    dictpoke[poke] = i

for _ in range(m):
    cmd = sys.stdin.readline().strip()
    if cmd.isdigit():
        print(pokedict[int(cmd)])
    else :
        print(dictpoke[cmd])