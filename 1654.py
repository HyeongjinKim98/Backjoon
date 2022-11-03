n, k = map(int,input().split())

line =[]
for i in range (0,n):
    line.append(int(input()))

start = 1
end = max(line)
res =0

while start<=end:
    cnt =0
    mid = (start+end)//2
    for i in line:
        cnt += i//mid

    if cnt >=k:
        start = mid+1
        res = mid
    else:
        end = mid-1

print(res)