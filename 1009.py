case = int(input())
for i in range(case):
    a,b = map(int, input().split())
    n = a%10

    if(n==0):
        print(10)
    elif(n==1 or n==5 or n==6):
        print(n)
    elif(n==2 or n==3 or n==7 or n==8):
        print((n**(b%4))%10)
    elif(n==4 or n==9):
        print((n**(b%2))%10)