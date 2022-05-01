N, X = map(int, input().split())

#입력값을 리스트로 넣는법
a = list(map(int, input().split()))

for _ in range (0,N):
    if(a[_]<X) : print(a[_])