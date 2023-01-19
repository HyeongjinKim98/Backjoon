def solution(k, m, score):
    answer = 0
    apple = sorted(score,reverse = True)
    box =[apple[i:i+m] for i in range(0,len(apple),m)
          if len(apple[i:i+m])==m ]
    for i in box:
        answer += min(i)*len(i)
    return answer