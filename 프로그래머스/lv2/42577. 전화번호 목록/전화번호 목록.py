def solution(phone_book):
    hash = {}
    
    for numbers in phone_book:
        hash[numbers] = True;
        
    for number in phone_book:
        start = ""
        for digit in number:
            start += digit;
            
            if start in hash and start != number : return False
        
    return True