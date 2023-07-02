N = "IO"*(int(input())) + "I"
M = int(input()) # S의 길이
S = input().rstrip()
res = 0
idx = 0

while idx<M-1:
    if S[idx:idx+len(N)] == N :
        res += 1
        idx += 2
    else :
        idx += 1
print(res)