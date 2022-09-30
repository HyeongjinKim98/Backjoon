n=int(input())
while n>0:
    li = list(map(int,str(n)))
    length = len(li)
    isPel = True
    for i in range(0, round(length/2)):
        if li[i]!=li[length-i-1] :
            isPel = False

    if isPel :
        print("yes")
    else :
        print("no")
    n = int(input())
