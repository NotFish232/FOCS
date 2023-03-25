import time


def printSet(list):
    print('------')
    print(str(list[0])+' '*(6-len(str(list[0])) -
          len(str(list[1])))+str(list[1]))
    print()
    print(str(list[2])+' '*(6-len(str(list[2])) -
          len(str(list[3])))+str(list[3]))
    print('------')


def addToFile(list):
    with open("ch24.txt", "a") as file:
        file.write(list+'\n')


def getCards():
    import random
    cards = []
    while not isSolvable(cards):
        cards = [random.randint(1, 12) for i in range(4)]
    return cards


def isSolvable(cards):
    if len(cards) == 1:
        return cards[0] == 24
    for i in range(len(cards)):
        for j in range(len(cards)):
            if (i != j):
                newCards = []
                for m in range(len(cards)):
                    if (m != i and m != j):
                        newCards.append(cards[m])
                newCards.append(cards[i]+cards[j])
                if (isSolvable(newCards)):
                    return True
                newCards.pop()
                newCards.append(cards[i]-cards[j])
                if (isSolvable(newCards)):
                    return True
                newCards.pop()
                newCards.append(cards[i]*cards[j])
                if (isSolvable(newCards)):
                    return True
                newCards.pop()
                if (cards[j] != 0):
                    newCards.append(cards[i]/cards[j])
                if (isSolvable(newCards)):
                    return True
    return False


def play():
    currentSet = getCards()
    while True:
        copy = currentSet.copy()
        clock = time.time()
        while not(copy.count('') == 3 and 24 in copy):
            printSet(copy)
            x = input("Input your first number: ")
            if x == 'R' or x == 'r':
                copy = currentSet.copy()
                continue
            if x == 'Q' or x == 'q':
                return
            while not x.isdigit() or int(x) not in copy:
                x = input("Please try again: ")
            copy[copy.index(int(x))] = ''
            print('1: +\n2: -\n3: ×\n4: ÷')
            y = input("choose the operator you would like to use: ")
            if y == 'R' or y == 'r':
                copy = currentSet.copy()
                continue
            if y == 'Q' or y == 'q':
                return
            while y != '1' and y != '2' and y != '3' and y != '4':
                y = input('Please try again: ')
            y = {'1': '+', '2': '-', '3': '*', '4': '/'}[y]
            printSet(copy)
            z = input("Input your second number: ")
            if z == 'R' or z == 'r':
                copy = currentSet.copy()
                continue
            if z == 'Q' or z == 'q':
                return
            while not z.isdigit() or int(z) not in copy:
                z = input("Please try again: ")
            copy[copy.index(int(z))] = round(eval(x+y+z))
        printSet(copy)
        print('You solved', currentSet, 'in', round(
            time.time()-clock, 2), 'seconds!')
        addToFile(str(currentSet)+' ' +
                  str(round(time.time()-clock, 2)))
        currentSet = getCards()


play()
