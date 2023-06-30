cook = [list(map(int,input().split())) for _ in range(5)]

sum = [0]*5
maxNum = 0
idx = 0
for i in range(5) :
    for score in cook[i]:
        sum[i] += score

    if sum[i] >= maxNum :
        idx = i
        maxNum = sum[i]

print(f"{idx+1} {maxNum}")

