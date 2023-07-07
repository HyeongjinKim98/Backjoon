for i in range(int(input())):
    dict ={}
    for j in range(int(input())):
        item = list(input().split())
        if item[1] in dict:
            dict[item[1]].append(item[0])
        else:
            dict[item[1]] = [item[0]]
    res = 1
    for k in dict :
        res *= len(dict[k]) + 1
    print(res-1)