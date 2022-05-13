case = int(input())
for i in range(case):
    case2 = int(input())
    win = 0
    for i in range(case2):
        p1, p2 = input().split()
        if((p1=='R' and p2=='S')or(p1=='S' and p2=='P')or(p1=='P' and p2=='R')):
            win+=1
        if((p1=='R' and p2=='P')or(p1=='S' and p2=='R')or(p1=='P' and p2=='S')):
            win-=1
    if(win > 0):
        print("Player 1")
    elif(win < 0):
        print("Player 2")
    else:
        print("TIE")
    win = 0