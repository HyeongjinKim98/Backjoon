#Hash

import math

n = int(input())
wd = input()
wd_list = list(wd)
ord_list=[]
hash = 0
for i in wd_list:
    ord_list.append(ord(i)-96)

for j in range(1,n+1):
    hash += ord_list[j-1]*math.pow(31,j-1)

print(int(hash))



