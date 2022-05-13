word = input().upper()  # 대문자 변경
s = list(set(word)) # set자체로는 index로 value 꺼내기 불가능, list로 변환
c = list()
max_index = 0
m_list = list()
for i in range(len(s)):
    tmp = word.count(s[i])
    c.append(tmp)
    if(tmp>=c[max_index]) :
        if(tmp>c[max_index]) :
            max_index = i
            m_list.clear()
        m_list.append(c[max_index])

        # 알파벳 갯수 최댓값을 m_list에 append
        # 최댓값 갱신, list.clear() 후 append

if(len(m_list)>1):print('?')
else: print(s[max_index])