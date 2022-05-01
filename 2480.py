fi, se, th = map(int, input().split())
#띄어쓰기로 입력값 구분

if fi == se == th:
    sum = 10000+fi*1000
elif(fi == se):
    sum = 1000 + fi * 100
elif (th == se):
    sum = 1000 + se * 100
elif (fi == th):
    sum = 1000 + th * 100
else :
    if fi>=se:
        if(fi>=th):
            sum = fi*100
        else:
            sum = th*100
    else:
        if(se>=th):
            sum = se*100
        else:
            sum = th*100
print(sum);