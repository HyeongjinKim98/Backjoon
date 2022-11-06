import sys

n = int(sys.stdin.readline())
cnt =0

def factorial(n):
    if n>1:
        return n*factorial (n-1)
    else:
        return 1

res = factorial(n)
while True:
    if res%5 == 0 :
        cnt+=1
        res = res//5
    else :
        break
print(cnt)