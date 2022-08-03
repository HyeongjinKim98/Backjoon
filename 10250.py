case = int(input())
floor = 0
room = 0

for _ in range(case):
    h,w,n = map(int,input().split())
    floor = n%h
    room = 1 + n//h
    if n%h==0:
        floor = h
        room -=1
    print(floor*100+room)

