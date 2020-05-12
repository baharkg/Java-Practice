global size, board, mines
size=0
board=[]
mines=[]

def mines_(num_mines):
    global size
    global mines
    for i in range(size):
        row=[]
        for j in range(size):
            row.append(0)
        mines.append(row)
    import random
    while num_mines != 0:
        i = random.randint(0,size-1)
        j = random.randint(0,size-1)
        
        if mines[i][j]==0:
            mines[i][j] = 1
            num_mines -= 1
        else:
          pass



def create_board(board_size, num_mines):
    global size
    size=board_size
    for c in range(size):
        row_=[]
        for d in range(size):
            row_.append(0)
        board.append(row_)
        
    mines_(num_mines)


def print_board(show_mines=False):
    global board
    if show_mines:
        for i in range(size):
            for j in range(size):
                print(mines[i][j], end='\t')
            print('')

    else:
        for i in range(size):
            for j in range(size):
                if board[i][j] == 2:
                    print('p',end='\t')
                elif board[i][j]==0:
                    print('#',end='\t')
                elif board[i][j]==1:
                    print(str(count_mines(i,j)),end='\t')
                elif reveal_cell(i,j)==-1:
                    print('@', end='\t')
            print('')


    #flag!!


def put_flag(row,col):
    global board
    board[row][col]=2


def remove_flag(row,col):
    global board
    board[row][col]=0


def count_mines(row,col):
    global mines
    num_mine=0
    for i in range(row-1,row+2):
        for j in range(col-1,col+2):
            if i>=size or j>=size or i<=0 or j<=0 :
                continue
            else:
                if mines[i][j]==1:
                    num_mine+=1
    return num_mine


def reveal_cell(row,col):
    global mines
    global board
    if mines[row][col]==0:
        board[row][col]=1
        return count_mines(row,col)
    elif mines[row][col]==1:
        return -1


def won():
    for i in mines:
        for j in mines[i]:
            if mines[i][j]==1 and board[i][j]!=2:
                return False
    return True


def main():
    global size, board, mines
    board_size=int(input('Enter board_size: '))
    num_mines=int(input('Enter num_mines: '))
    create_board(board_size,num_mines)
    print_board()
    while True:
        character=input('please enter character: ')
        character=character.split()
        C = character[0]
        row = int(character[1])-1
        col = int(character[2])-1
        if C=='r':
            reveal_cell(row,col)
            print_board()
        if C=='f':
            put_flag(row,col)
            print_board()
        if C=='u':
            remove_flag(row,col)
            print_board()
        if C=='x':
            if won()==True:
                return 'You Won!'
            elif won()==False:
                return 'You Lost!'
        elif C!='x' and C!='f' and C!='r' and C!='u':
            print('Invalid Command')

print(main())
