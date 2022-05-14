case = int(input())
new = ''
for _ in range(case):
    num, word = input().split()
    for i in range(len(word)):
        for _ in range(int(num)):
            new += word[i]
    print(new)
    new = ''