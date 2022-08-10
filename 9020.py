n, m = map(int, input().split())
num = list(map(int, input().split()))
def cal(num, m):
    num.sort(reverse=True)
    print(num[m - 1])
sol(num, m)