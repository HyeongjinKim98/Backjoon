t = map(int, input().split())
score = list(map(int, input().split()))
max = 0
sum = 0
for i in range(len(score)):
    sum += score[i]
    if(score[i]>max): max = score[i]
new = (sum/max)*100/len(score)
print(new)