def solution(number):
    answer = 0
    length = len(number)
    for i in range (length):
        for k in range(i+1,length):
            for j in range(k+1,length):
                if number[i]+number[k]+number[j]==0 :
                    answer += 1

    return answer