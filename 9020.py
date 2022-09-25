case = int(input())

def gb_partition(n):
    a = []
    for i in range (2,round(n/2)+1):
        if(isPrime(i) and isPrime(n-i)):
            a.append([i,n-i])

    if len(a)%2==0 :
        print(a[int(len(a)/2)-1][0],a[int(len(a)/2)-1][1])
    else :
        print(a[round(len(a)/2)-1][0],a[round(len(a)/2)-1][0])

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
        return True
    else : return False

for _ in range(case):
    n = int(input())
    gb_partition(n)
