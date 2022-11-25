import sys

n,m = map(int,sys.stdin.readline().split())
dict = {}
for _ in range(n):
    add,pw = sys.stdin.readline().split()
    dict[add] = pw

for _ in range(m):
    find = sys.stdin.readline().strip()
    print(dict.get(find))
