##한수
n = int(input())
cnt = 0
for l in range(1,n+1):
    if l<100 :
        cnt+=1
    else:
        li = list(map(int,str(l)))
        if(li[0]-li[1]==li[1]-li[2]):
            cnt +=1
print(cnt)
