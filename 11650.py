case = int(input())
li =[]
for i in range(0, case):
    m,n = map(int,input().split())
    li.append([m,n])

li.sort(key=lambda x: (x[0], x[1]))

for i in li:
    print(i[0],i[1])