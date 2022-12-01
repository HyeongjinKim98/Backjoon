#remote controller

N = int(input())
M = int(input())
if M:
    broken = set(input().split())
else:
    broken = set()

res = abs(N-100)
for i in range(1000001):
    for d in str(i):
        if d in broken:
            break
    else :
        res = min(res,len(str(i)) + abs(N-i))
print(res)
