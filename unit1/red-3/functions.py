def slice_end(string,index):
    return string[index:]

def pig_latin(string):
    return string[1:]+string[:1]+'ay'

def shrink(string):
    if (len(string)==0): return
    print(string)
    shrink(string[:len(string)-1])

def grow(string):
    if (len(string)==0): return
    grow(string[:len(string)-1])
    print(string)

def shrink_right(string,spaceCounter=0):
    if (len(string)==0): return
    print(" "*spaceCounter+string)
    spaceCounter+=1
    shrink_right(string[1:],spaceCounter)

def word_cascade(string):
    grow(string)
    shrink_right(string[1:],1)  

def cascade_backwards(string,distanceFromEnd=1):
    if distanceFromEnd == len(string):
        shrink(string)
    else:
        print(' '*(len(string)-distanceFromEnd-1),string[len(string)-distanceFromEnd:])
        cascade_backwards(string, distanceFromEnd+1)

def snake(string):
   custom_snake(string,3)
   
def custom_snake(string,snakeWidth,index=0, directionCount=0,direction='right'):
    if (index==len(string)): return
    print(' '*directionCount,string[index])
    if (directionCount>=snakeWidth-1): direction='left'
    if (directionCount==0): direction='right'
    if (direction=='right'): custom_snake(string,snakeWidth,index+1,directionCount+1,direction)
    if (direction=='left'): custom_snake(string,snakeWidth,index+1,directionCount-1,direction)



import sys
s = sys.argv[1]
print("Shrink:")
print()
shrink(s)
print()
print("Grow:")
print()
grow(s)
print()
print("Shrink right:")
print()
shrink_right(s)
print()
print("Word cascade:")
print()
word_cascade(s)
print()
print("Cascade backwards:")
print()
cascade_backwards(s)
print()
print("Snake:")
print()
snake(s)
print()
print("Custom snake:")
print()
custom_snake(s, int(sys.argv[2]))
custom_snake(s, int(sys.argv[2]))