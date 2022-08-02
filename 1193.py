n = int(input())
count = 0
line = 1

while n>line:
    n = n-line
    line +=1

a = n
b = line -(n-1)
if(line%2==0) :
    print("%d/%d"%(a,b))
else:
    print("%d/%d"%(b,a))