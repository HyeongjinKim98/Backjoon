survey = ["AN", "CF", "MJ", "RT", "NA"]
choices = [5,3,2,7,5]

# (R T), (C F) (J M) (A N)
def solution(survey, choices):
    answer =''
    dic = {'R':0,'T':1,'C':2,'F':3,'J':4,'M':5,'A':6,'N':7}
    score = [0]*8
    for i in range(len(survey)):
        if choices[i]<4:
            score[dic[survey[i][0]]] -= choices[i]-4
        elif choices[i]>4:
            score[dic[survey[i][1]]] += choices[i]-4

    answer += 'T' if score[0] < score[1] else 'R'
    answer += 'F' if score[2] < score[3] else 'C'
    answer += 'M' if score[4] < score[5] else 'J'
    answer += 'N' if score[6] < score[7] else 'A'
    return answer
print(solution(survey,choices))