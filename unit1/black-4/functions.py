def pyramid(string,depth=0):
    if (len(string)//2<depth): return
    print(' '*(len(string)//2-depth) + string[len(string)//2-depth:len(string)//2+depth+1])
    pyramid(string,depth+1)

def spike(string,depth=0):
    if (len(string)//2<depth): return 
    print(' '*depth + string[depth:len(string)-depth])
    spike(string,depth+1)

def diamond(string,depth=0):
    if (depth==len(string)): return
    if (depth<len(string)//2):
        print(' '*(len(string)//2-depth) + string[len(string)//2-depth:len(string)//2+depth+1])
    elif (depth>len(string)//2):
        print(' '*(depth-len(string)//2) + string[depth-len(string)//2:len(string)-depth+len(string)//2])
    else:
        print(string)
    diamond(string,depth+1)

def sidewinderHelper(arrayOfStrings,string,length,index=0,direction='down',depth=0):
    if (index==len(string)): return arrayOfStrings
    if (depth==0): direction='down'
    if (depth==length-1): direction='up'
    arrayOfStrings[depth]+=string[index]
    addSpace(depth,arrayOfStrings)
    if (direction=='down'): depth=depth+1
    else: depth=depth-1
    return sidewinderHelper(arrayOfStrings,string,length,index+1,direction,depth)

def addSpace(x,arrayOfStrings,index=0):
    if (index==len(arrayOfStrings)): return arrayOfStrings
    if (index==x): return addSpace(x,arrayOfStrings,index+1)
    arrayOfStrings[index]+=' '
    return addSpace(x,arrayOfStrings,index+1)

def sidewinder(string):
    print(*sidewinderHelper(['']*3,string,3), sep = "\n")

def custom_sidewinder(string,length):
    print(*sidewinderHelper(['']*length,string,length), sep = "\n")

def magic_square(string):
    print(*magic_square_helper(['']*(len(string)+4),string,len(string)+4,magic_square_diamond(['']*len(string),string)),sep="\n")

def magic_square_helper(arrayOfStrings,string,totalDepth,diamond,index=0,depth=0):
    if (depth==totalDepth): return arrayOfStrings
    if (depth<=-(-len(string)//2)):
        arrayOfStrings[depth]+=string[:-(-len(string)//2)-depth] 
    if (depth>=totalDepth-1-len(string)//2):
        arrayOfStrings[depth]+=string[:depth+(-len(string)//2)-2]  
    if (depth>=2 and depth<=1+len(string)):
        if (depth==len(string)//2+2):
            arrayOfStrings[depth]+='  ' +diamond[depth-2]+'  '
        elif (depth<=len(string)//2+2): 
            arrayOfStrings[depth]+='   ' +diamond[depth-2] + '   '
        else:
            arrayOfStrings[depth]+='   ' +diamond[depth-2] + '   '
    else:
        if (depth<=-(-len(string)//2)): arrayOfStrings[depth]+=' ' * (3+2*depth) 
        else: arrayOfStrings[depth]+=' ' * (2*(totalDepth-depth)+1)
    if (depth<=-(-len(string)//2)):
        arrayOfStrings[depth]+=string[len(string)//2+depth:]
    if (depth>=totalDepth-1-len(string)//2):
        arrayOfStrings[depth]+=string[len(string)-1-depth-(-len(string)//2)+3:]
    return magic_square_helper(arrayOfStrings,string,totalDepth,diamond,index+1,depth+1)

def magic_square_diamond(arrayOfStrings,string,depth=0):
    if (depth==len(string)): return arrayOfStrings
    if (depth<len(string)//2):
        arrayOfStrings[depth]+=string[len(string)//2-depth:len(string)//2+depth+1]
    elif (depth>len(string)//2):
        arrayOfStrings[depth]+=string[depth-len(string)//2:len(string)-depth+len(string)//2]
    else:
        arrayOfStrings[depth]+=string
    return magic_square_diamond(arrayOfStrings,string,depth+1)
def word_art_19(string,index=0):
    if (len(string)==0): return
    print(index%3*' ' + string[0])
    word_art_19(string[1:],index+1)
import sys
s = sys.argv[1]
print("Pyramid:")
print()
pyramid(s)
print()
print("Spike:")
print()
spike(s)
print()
print("Diamond:")
print()
diamond(s)
print()
print("Magic square:")
print()
magic_square(s)
print()
print("Sidewinder:")
print()
sidewinder(s)
print()
print("Custom sidewinder:")
print()
custom_sidewinder(s, int(sys.argv[2]))
print()
print("Stripes") 
print()
word_art_19(s)
print()