for _ in range(int(input())):
    N = int(input())
    arr = [1, 1, 1, 2, 2]

    if N < 5 :
        print(arr[N-1])
    else :
        for i in range(5,N):
            arr.append(arr[i-1]+ arr[i-5])
        print(arr[-1])