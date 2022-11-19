import sys

def cal(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    else:
        return cal(n-1) + cal(n - 2) + cal(n - 3)

case = int(sys.stdin.readline())
test = []
for _ in range(case):
    test.append(int(sys.stdin.readline()))

for num in test:
    print(cal(num))
