import sys
input = sys.stdin.readline
N,K = map(int,input().split())
num = input().rstrip()
stack = []
for item in num :
    while stack and stack[-1] < item and K>0 :
        stack.pop()
        K -=1
    stack.append(item)
if K > 0:
    print(''.join(stack[:-K]))
else:
    print(''.join(stack))