board = [4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0]
 
def board_printer(board):
    start = 0
    for i in board:
        board[start] = int(board[start])
        if int(board[start]) < 10:
            board[start] = " " + str(board[start])
        else:
            board[start] = str(board[start])
        start = start+1
    print("-----------------------------------------")
    print("|    | " + board[12] + " | " + board[11] + " | " + board[10] + " | " + board[9] + " | " + board[8] + " | " + board[7] + " |    |")
    print("| " + board[13] + " |-----------------------------| " + board[6] + " |")
    print("|    | " + board[0] + " | " + board[1] + " | " + board[2] + " | " + board[3] + " | " + board[4] + " | " + board[5] + " |    |")
    print("-----------------------------------------")
    print("        0    1    2    3    4    5")
 
def move_player_1(choice):
    x = 0
    board[choice] = int(board[choice])
    i = int(board[choice])
    board[choice] = 0
    while x<i:
        if choice == 13:
            choice = -1
            board[choice + 1] = int(board[choice + 1]) + 1
            choice = choice + 1
            x = x+1
        elif choice == 12:
            choice = choice+1
            x= x+1
        else:
            board[choice + 1] = int(board[choice + 1]) + 1
            choice = choice + 1
            x = x+1
    if board[choice] == 1 and choice == 6:
        board_printer(board)
        choice = input("Player one, you get to move again. Choose another column: ")
        move_player_1(int(choice))
    elif board[choice] == 1 and 1<=choice<=5:
        board_printer(board)
        print("Well, well ... it seems you get to take both this stone and the one across from it (unless the across spot has no stones.)")
        board[6] = board[choice] + 1 + board[12-choice]
    else: board_printer(board)
   
def move_player_2(choice):
    x = 0
    choice = 12-choice
    board[choice] = int(board[choice])
    i = int(board[choice])
    board[choice] = 0
    while x<i:
        if choice == 6:
            board[choice + 1] = int(board[choice + 1]) + 1
            choice = choice + 1
            x = x+1
        elif choice == 5:
            choice = choice+1
            x= x+1
        elif choice == 13:
            choice = -1
            board[choice + 1] = int(board[choice + 1]) + 1
            choice = choice + 1
            x = x+1
        else:
            board[choice + 1] = int(board[choice + 1]) + 1
            choice = choice + 1
            x = x+1
    if board[choice] == 1 and choice == 13:
        board_printer(board)
        choice = input("Player two, you get to move again. Choose another column: ")
        move_player_2(int(choice))
    elif board[choice] == 1 and 8<=choice<=12:
        board_printer(board)
        print("Well, well ... it seems you get to take both this stone and the one across from it (unless the across spot has no stones.)")
        board[13] = 1 + board[12-choice]
        board[choice] = 0
        board[12-choice] = 0
    board_printer(board)
 
 
def play(board):
    counter=0
    board_printer(board)
    choice = input("Play (P) or Quit (Q): ").upper()
    while choice!='Q':
        board_printer(board)
        if counter%2==0:
            print("Player one's turn: ")
            choice = input("Which column do you want to move? ")
            while board[int(choice)] == 0:
                choice = input("Please choose a column that has stones in it: ")
            move_player_1(int(choice))
        elif counter%2==1:
            print("Player two's turn: ")
            choice = input("Which column do you want to move? ")
            while board[int(choice)] == 0:
                choice = input("Please choose a column that has stones in it: ")
            move_player_2(int(choice))
        counter+=1
           
       
play(board)
