# stack
import sys
case = int(sys.stdin.readline())
list =[]
for i in range(case):
    cmd = sys.stdin.readline().split()
    if(cmd[0]=='push'):
        list.append(cmd[1])
    elif(cmd[0]=='pop'):
        if(len(list)>0):
            print(list.pop())
        else:
            print(-1)
    elif (cmd[0] == 'size'):
        print(len(list))
    elif (cmd[0] == 'empty'):
        if len(list)==0:
            print(1)
        else :
            print(0)
    elif (cmd[0] == 'top'):
        if len(list)==0:
            print(-1)
        else:
            print(list[-1])
