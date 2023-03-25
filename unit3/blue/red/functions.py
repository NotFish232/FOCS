def play():
    x = input('New Game (N) or Load Saved Game (L) ').upper()
    if x == 'L':
        board = fileToList()
    elif x == 'N':
        board = [['.' for i in range(7)] for i in range(6)]
        listToFile(board)
    else:
        print('Unrecognized Command, Please Try Again')
        play()
        return
    while True:
        printBoard(board)
        x = input('Player '+whoseTurn(board)+' moves next.'+'\n'+'Choose your column, or (S) to save and quit:')
        if x == 'S' or x == 's':
            print('Your game has been saved!')
            listToFile(board)
            return
        if x == 'Q' or x == 'q':
            return
        tempBoard=makeMove(board,x)
        while tempBoard == 'error':
            x = input('Please try again ')
            if x=='S' or x=='s': 
                print('Your game has been saved!')
                listToFile(board)
                return
            if x == 'Q' or x == 'q':
                return
            tempBoard=makeMove(board,x)
        board = tempBoard
        if isWon(board,'X'): 
            printBoard(board)
            print('Player X Won!')
            return
        if isWon(board,'O'):
            printBoard(board)
            print('Player O Won!')
            return
            
def isWon(board,letter):
    for i in range(len(board)):
        for j in range(len(board[0])-3):
            if board[i][j] +board[i][j+1]+board[i][j+2]+board[i][j+3]==4*letter: return True
    for i in range(len(board)-3):
        for j in range(len(board[0])):
            if board[i][j] +board[i+1][j]+board[i+2][j]+board[i+3][j]==4*letter: return True
    for i in range(3,len(board)):
        for j in range(0,len(board[0])-3):
            if board[i][j]+board[i-1][j+1]+board[i-2][j+2]+board[i-3][j+3]==4*letter: return True
        for j in range(3,len(board[0])):
            if board[i][j] +board[i-1][j-1]+board[i-2][j-2]+board[i-3][j-3]==4*letter: return True
    return False
                         
def makeMove(board, column):
    if not column.isdigit() or int(column)>6 or int(column)<0: return 'error'
    column=int(column)
    for i in range(5,0,-1):
        if board[i][column]=='.':
            board[i][column]=whoseTurn(board)
            break
    return board

def listToFile(listOfLists):
    for i in listOfLists:
        open("savegame.txt", "w").write(''.join(i)+'\n')

def fileToList():
    return [list(line.strip()) for line in open('savegame.txt')]

def printBoard(board):
    print('Current Gameboard:')
    print('-----------------------------')
    [print('| '+''.join(j+ ' | ' for j in i)) for i in board]
    print('-----------------------------')
    print('  0   1   2   3   4   5   6')

def whoseTurn(board):
    if sum(i.count('X') for i in board) == sum(i.count('O') for i in board): return 'X'
    return 'O'
play()