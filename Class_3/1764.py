import sys

n,m = map(int,sys.stdin.readline().split())

heard = set()
seen = set()

for _ in range(n):
    heard.add(sys.stdin.readline().rstrip())

for _ in range(m):
    seen.add(sys.stdin.readline().rstrip())

heardNseen = sorted(list(heard & seen))

print(len(heardNseen))

for item in heardNseen:
    print(item)