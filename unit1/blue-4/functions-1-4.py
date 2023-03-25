def avg_3(x,y,z):
    average=(x+y+z)/3
    print(average)
    return average
def string_is_blah(string):
    return string=='blah'
def guessYourNumber(lowerBound=0,upperBound=100, guessCount=1):
    guess=(upperBound+lowerBound)//2
    print("I think this is your number:", guess)
    userEntry = input("correct / low / high: ")
    if (userEntry.lower()=='correct'): print("I guessed your number!. It took this many guesses:", guessCount)
    elif (userEntry.lower()=='low'): guessYourNumber(guess,upperBound,guessCount+1)
    elif (userEntry.lower()=='high'): guessYourNumber(lowerBound,guess,guessCount+1)
    else: print("ERROR, did not recognize:", userEntry)
guessYourNumber()

