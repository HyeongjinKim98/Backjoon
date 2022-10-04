#blackjack
#브루트포스

n,m = map(int,input().split())
cards = list(map(int, input().split()))
pair =[]
res = 0
for i in range (0,n-2):
    for l in range(i+1,n-1):
        for k in range(l+1,n):
            if cards[i]+cards[l]+cards[k]>m:
                continue
            else:
                res = max(res,cards[i]+cards[l]+cards[k])

print(res)


