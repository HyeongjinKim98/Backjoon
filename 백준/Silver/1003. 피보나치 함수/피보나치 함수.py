def fib(n):
  zero = [1, 0, 1]
  one = [0, 1, 1]
  if len(zero) <= n:
    for i in range(len(zero), n+1):
      zero.append(zero[i-2]+zero[i-1])
      one.append(one[i-2]+one[i-1])
  return zero[n], one[n]
for _ in range(int(input())):
    a, b = fib(int(input()))
    print(a,b)