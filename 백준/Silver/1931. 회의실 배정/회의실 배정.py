n = int(input())
room = []

for i in range(n):
    a, b = map(int, input().split())
    room.append([a, b])

room.sort(key = lambda x: (x[1],x[0]))

end = 0
cnt = 0

for s,e in room:
    if s>=end:
        cnt +=1
        end = e
print(cnt)
