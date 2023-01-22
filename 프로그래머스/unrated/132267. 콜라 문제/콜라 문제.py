def solution(a, b, n):
    answer = 0
    
    while n>=a and n>=2 :
        get = (n//a)*b
        n = n%a
        n += get
        answer += get
    return answer