def div(num):
    li = []
    for i in range(1,int(num**(1/2))+1):
        if num%i==0:
            li.append(i)
            if((i**2)!=num):
                li.append(num//i)
    return len(li)

def solution(number,limit,power):
    answer = 0
    li =[]
    for i in range(1,number+1):
        tmp = div(i)
        li.append(tmp)
        if tmp > limit:
            tmp = power
        answer+=tmp

    return answer