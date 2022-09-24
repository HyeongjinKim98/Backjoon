m,n = map(int,input().split())
def cal(m,n):
    for i in range(m,n+1):
        isPrime(i)

def isPrime(n):
    flag = 0
    if(n==1):
        flag = 1
    else:
        for i in range (2,int(n**0.5)+1):
            if(n%i==0):
                flag = 1
                break
    if flag==0 :
        print(n)

cal(m,n)
