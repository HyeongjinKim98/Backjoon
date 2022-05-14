max = 0
max_index = 0
for k in range(9):
    i = int(input())
    if(i>=max):
        max = i
        max_index = k+1
print(max)
print(max_index)