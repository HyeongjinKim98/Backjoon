n = int(input())
s=[]
result=[]
count = 1
tmp = True
for i in range(n):
    i = int(input())
    while count<=i:
        s.append(count)
        result.append('+')
        count+=1
    if s[-1]==i:
        s.pop()
        result.append('-')
    else :
        tmp = False
if tmp == False:
    print("NO")
else :
     for i in result:
         print(i)
