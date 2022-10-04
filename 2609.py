a,b = map(int,input().split())

n,m = min(a,b),min(a,b)
li = []
for i in range(1,m+1):
    if a%i==0 and b%i==0 :
        li.append(i)

print(max(li))
print(int((a*b)/max(li)))