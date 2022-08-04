n = int(input())

nums = map(int, input().split())
count = 0
for n in nums:
    tmp = 0
    if n >1:
        for i in range(2,n):
            if n%i == 0:
                tmp +=1
        if tmp == 0:
            count +=1
print(count)