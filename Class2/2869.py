import math
up, down, v = map(int,input().split())
h = 0
day = math.ceil((v-up)/(up-down))+1
print(day)