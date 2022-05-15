def pal(i):
    length = len(i)
    error = 0
    for n in range(length+1):
        if(i[n]==i[length-n]):
            pass
        else :
            error +=1
    if error>0 : return 0
    else : return 1


while True:
         line  = input()
         print(pal(line))
