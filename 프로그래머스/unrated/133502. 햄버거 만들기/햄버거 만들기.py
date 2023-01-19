def solution(ingredient):
    answer = 0
    table = []
    com = [1,2,3,1]
    for item in ingredient:
        table.append(item)
        if table[-4:] == com:
            answer +=1
            for _ in range(4):
                table.pop()
    return answer