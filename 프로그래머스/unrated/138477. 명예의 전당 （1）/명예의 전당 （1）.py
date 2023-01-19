def solution(k, score):
    hof =[]
    answer = []
    for sc in score :
        hof.append(sc)
        hof.sort(reverse=True)
        if(len(hof)>k):
            hof.pop(-1)

        answer.append(hof[-1])

    return answer