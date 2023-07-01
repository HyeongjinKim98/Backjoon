import sys

def roundfunc(num):
    return int(num) + 1 if num - int(num) >= 0.5 else int(num)

N = int(sys.stdin.readline())
if N > 0 :
    arr = [int(sys.stdin.readline()) for _ in range(N)]
    arr.sort()
    cut = roundfunc(N*0.15)
    print(roundfunc(sum(arr[cut:-cut] if cut else arr)/(N-2*cut)))
else : print(0)