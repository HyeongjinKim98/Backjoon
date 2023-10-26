n, m = map(int,input().split())
tree = list(map(int,input().split()))

start = 1
end = max(tree)

while start<=end :
    mid = (start+end)//2
    ans = 0
    for t in tree:
        if(t>=mid):
            ans += t-mid
    if ans>=m :
        start = mid+1
    else :
        end = mid-1

print(end)