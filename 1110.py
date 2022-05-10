org = int(input())
cycle = -1;
def cal(input,cycle):
    cycle += 1
    new = divmod(input,10)
    if(input==org and cycle>0):
         print(cycle)
    else:
        cal(new[1]*10+(new[0]+new[1])%10,cycle)
cal(org,cycle)

