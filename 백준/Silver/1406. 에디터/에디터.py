import sys

N = list(sys.stdin.readline().rstrip())
M = []

for _ in range(int(sys.stdin.readline())):
    cmd = list(sys.stdin.readline().split())
    if cmd[0] == "L" :
        if N :
            M.append(N.pop())
    elif cmd[0] == "D":
        if M :
            N.append(M.pop())
    elif cmd[0] == "B":
        if N :
            N.pop()
    else :
        N.append(cmd[1])

N.extend(reversed(M))
print(''.join(N))