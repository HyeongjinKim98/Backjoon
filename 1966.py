#printer queue
from collections import deque

case = int(input())

for i in range(0, case):
    n,m = map(int, input().split())
    printer =deque(list(map(int,input().split())))
    cnt =0
    while printer:
        maxval = max(printer)
        fi = printer.popleft()
        m-=1
        if maxval==fi:
            cnt +=1
            if(m<0):
                print(cnt)
                break
        else :
            printer.append(fi)
            if (m < 0):
                m = len(printer)-1

