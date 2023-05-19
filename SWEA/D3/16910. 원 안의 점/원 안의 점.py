T = int(input())

for i in range(0,T):
    N = int(input())
    cnt = 0

    for x in range(-N,N+1):
        for y in range(-N,N+1):
            if pow(x,2)+ pow(y,2) <= pow(N,2):
                cnt+=1

    print(f"#{i+1} {cnt}")