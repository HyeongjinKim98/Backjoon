def solution(s):
    ans = 0 ;
    if len(s) % 2 == 1 or s[0] == ')' : return False
    for c in s:
        if c == '(' : ans += 1
        else :
            if ans == 0 : return False
            else : ans -= 1
        
    if ans == 0 : return True
    else :  return False