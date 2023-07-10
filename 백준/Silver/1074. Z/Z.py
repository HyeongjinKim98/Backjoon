N, r, c = map(int,input().split())

def cal(R,C,N,count):
    if N == 0:
        print(count)
    else:
        cnt = count
        n = N - 1
        if R < 2 ** n and C >= 2 ** n:
            cnt += (2 ** n) * (2 ** n) * 1
            cal(R, C - 2 ** n, n, cnt)
        elif R >= 2 ** n and C < 2 ** n:
            cnt += (2 ** n) * (2 ** n) * 2
            cal(R - 2 ** n, C, n, cnt)
        elif R >= 2 ** n and C >= 2 ** n:
            cnt += (2 ** n) * (2 ** n) * 3
            cal(R - 2 ** n, C - 2 ** n, n, cnt)
        else:
            cal(R, C, n, cnt)

cal(r,c,N,0)