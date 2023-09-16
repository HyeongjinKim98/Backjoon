import math
def solution(progresses, speeds):
    answer = []
    stack = []
    for i in range(len(progresses)):
        current = math.ceil((100 - progresses[i]) / speeds[i])
        
        if len(stack) > 0 and stack[0] < current:
            answer.append(len(stack))
            stack.clear()   
        
            
        stack.append(current);
        
    if len(stack) > 0:
        answer.append(len(stack))
        
    return answer