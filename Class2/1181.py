case = int(input())
words = list()
for _ in range(case):
    words.append(input())
li = list(set(words))
li.sort()
li.sort(key =len)

for i in li:
    print(i)