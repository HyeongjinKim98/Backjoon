n = input()
count = 0
flag = False
def decompose(i):
    sum = 0
    for n in range(len(i)):
        sum += int(i[n])
    return sum+int(i)

for i in range(1, int(n)+1):
    count += 1
    count_st = str(count)
    tmp = decompose(count_st)

    if(tmp==int(n)):
        print(count)
        flag = True
        break
if flag == False:
    print(0)