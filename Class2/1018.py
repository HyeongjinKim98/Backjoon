row, col = map(int,input().split())
board = list()
for n in range (row):
    board.append(input())
next_board = list()

for i in range(row-7):
    for j in range(col-7):
        w = 0
        b = 0
        for k in range(i,i+8) :
            for l in range(j,j+8):
                if (k+l)%2 ==0:
                    if board[k][l] == 'W':
                        w += 1
                    if board[k][l] == 'B':
                        b += 1
                else:
                    if board[k][l] == 'B':
                        w += 1
                    if board[k][l] == 'W':
                        b += 1
        next_board.append(w)
        next_board.append(b)
print(min(next_board))