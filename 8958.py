case = int(input())

for _ in range(case):
    score = 0
    combo = 1
    word = input()
    for i in range(len(word)):
        if(word[i]=='O') :
            score += combo
            combo += 1
        elif(word[i]=='X') :
            combo = 1
    print(score)