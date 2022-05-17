#산술평균  : 미완
import math

case = int(input())
list = []
mode = [0]*100
mode_index = 0
second_mode_index = 0
length = case
for i in range(case):
    list.append(int(input()))

def avg(list):
    sum = 0

    for i in range(case):
        sum += list[i]
    return sum/case

for i in range(case):
    mode[list[i]] += 1

for i in range(case):
    if(mode[case]>=mode_index):
        second_mode_index = mode_index
        mode_index = case
print(round(avg(list)))
print(list[math.ceil(case/2)])
print(mode_index)