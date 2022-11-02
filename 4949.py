while(1):
    balance = True
    line = input().rstrip()
    stack = []
    for i in range(0, len(line)):
        if line[i] == "(" or line[i] == "[":
            stack.append(line[i])
        elif line[i] ==")":
            if stack and stack[-1] =="(":
                stack.pop()
            else :
                balance = False
                break
        elif line[i] =="]":
            if stack and stack[-1] =="[":
                stack.pop()
            else :
                balance = False
                break
    if line == '.':
        break
    if balance and not(stack):
            print("yes")
    else :
            print("no")
