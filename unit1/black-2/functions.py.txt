def star(string,index=0,depth=0):
    if (2*len(string)+1==depth): return
    if depth<len(string):
        space=' '*(2*(len(string)-depth)-1)
        character=string[len(string)-1-depth]
        print(' '*index*2 + character  + space + character + space + character)
        star(string,index+1,depth+1)
    if (depth==len(string)):
        print(' '.join(string[::-1]+'*'+string))
        star(string,0,depth+1)
    if (depth>len(string)):
        space=' '*(2*(depth-len(string)-1)+1)
        character=string[index]
        print(' '*(len(string)-1-index)*2 + character + space + character + space + character)
        star(string,index+1,depth+1) 

def mirror(string):
   print(string[::-1]+string)
   
def big_arch(string,depth=0):
    if depth==len(string): return
    if depth==0: print(string[0]+string+string[0])
    else: print (string[depth]+' '*len(string)+string[depth])
    big_arch(string,depth+1)

def word_art_11(string,count=20,depth=0):
    if (depth==len(string)): return
    print(' ' * depth + count*(string[depth] + '  ' ))
    word_art_11(string,count,depth+1)
    
def word_art_12(string,depth=0):
    if (len(string)==depth): return
    print(' '*(len(string)-depth-1) + ' '.join(string[0:depth+1]))
    word_art_12(string,depth+1)
import sys
s = sys.argv[1]
print("Mirror:")
print()
mirror(s)
print()
print("Big Arch:")
print()
big_arch(s)
print()
print("Star:")
print()
star(s)
print()
print("") # Add the name of YOUR word art #11 here!
print()
word_art_11(s)
print()
print("") # Add the name of YOUR word art #12 here!
print()
word_art_12(s)