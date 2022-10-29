n = int(input())
a= list(map(int,input().split()))

m = int(input())
b= list(map(int,input().split()))

cnt ={}

for card in a:
    if card in cnt:
        cnt[card] +=1
    else :
        cnt[card] = 1

for card in b:
    res = cnt.get(card)
    if(res ==None):
        print(0,end=" ")
    else:
        print(res,end=" ")