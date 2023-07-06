N = input()
stack = []
tmp = 0
for i in range(len(N)):
    if N[i] =='(' :
        stack.append(N[i])
    else :
        if N[i-1] =='(':
            stack.pop()
            tmp += len(stack)

        else :
            stack.pop()
            tmp +=1
print(tmp)
