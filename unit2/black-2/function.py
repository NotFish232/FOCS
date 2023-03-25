def simple_columnar_encode(text, c, fill):
    if fill: text+='X'*(c-len(text)%c)
    array=['' for i in range(c)]
    for i in range(len(text)):
        array[i%c]+=text[i]
    return ''.join(array)
print(simple_columnar_encode("TAKEABREAKDRIVEREIGHT",3,False))
def simple_columnar_decode(text, c):
    string=text+' '*(c-len(text)%c)
    array=['' for i in range(-(-len(string)//c))]
    for i in range(len(string)):
        array[i%(-(-len(string)//c))]+=string[i]
    print(array)
    return ''.join(array)
print(simple_columnar_decode("TERKIRGAAEDVEHKBAREIT",3))

def keyword_columnar_encode(text, keywd, fill):
    if fill: text+='X'*(len(keywd)-len(text)%len(keywd))
    else: text+=' '*(len(keywd)-len(text)%len(keywd))
    lists=[[] for i in range(len(keywd))]
    for i in range(len(text)):
        lists[i%len(keywd)]+=text[i]
    return ''.join([j[keywd.index(i)] for j in lists] for i in sorted(keywd))


def keyword_columnar_decode(text, keywd):
    text+=' '*(len(keywd)-len(text)%len(keywd))
    lists=[[] for i in range(len(keywd))]
    for i in range(len(text)):
        lists[i%(len(text)//len(keywd))]+=text[i]
    return ''.join(''.join(j[sorted(keywd).index(i)] for j in lists) for i in keywd)

    '''list = []
    if len(text) % len(keywd) == 0:
        list = [text[i:i+len(text)//len(keywd)]
                for i in range(0, len(text), len(text)//len(keywd))]
    else:
        binaryKey = []
        thing = len(text) % len(keywd)
        for i in range(len(keywd)):
            if thing > 0:
                binaryKey.append(1)
                thing -= 1
            else:
                binaryKey.append(0)
        binary = [binaryKey[keywd.index(sorted(keywd)[i])] for i in range(len(keywd))]
        i = 0
        j = 0
        while i < len(text):
            if binary[j] == 0:
                list.append(text[i:i+len(text)//len(keywd)]+' ')
                i += len(text)//len(keywd)
                j += 1
            else:
                list.append(text[i:i-(-len(text)//len(keywd))])
                i -= (-len(text)//len(keywd))
                j += 1
    newList = [list[sorted(keywd).index(keywd[i])] for i in range(len(keywd))]
    return  ''.join(''.join(''.join(newList[j])[i] for j in range(len(newList))) for i in range(len(''.join(newList[0])))).replace(' ', '')

'''
def helper(string, keyword):
    while True:
        print()
        print(keyword_columnar_decode(string, keyword), 'Keyword: ', keyword)
        print()
        x = input("What rows do you want to swap?")
        if x.lower() == 'quit':
            return
        y = keyword[int(x[0])]
        keyword = keyword[:int(x[0])]+keyword[int(x[1])]+keyword[int(x[0])+1:]
        keyword = keyword[:int(x[1])]+y+keyword[int(x[1])+1:]


def permute(string, contains='', contains2='', contains3='', keywordSize=10):
    string=string.upper()
    contains,contains2,contains3=contains.upper(),contains2.upper(),contains3.upper()
    Alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    from itertools import permutations
    list = []
    for i in range(keywordSize):
        list.append(Alpha[0:i+1])
    for i in list:
        for j in permutations(i):
            decoded=keyword_columnar_decode(string, j)
            if contains in decoded and contains2 in decoded and contains3 in decoded:
                print(decoded, 'keyword: ', ''.join(j))
        print('keywords of length', len(i), 'have been finished!')
    print('DONE!')
#permute('UVENNNIRTGSATOITNOIOHEAVTEHLEHHGAEEONTNWSNNHN','THESUN')
print(simple_columnar_decode("IHOSTSMTEFIHTEWBTTEOSAEIWWFSSMAOTTTESRI",6)) #IT WAS THE BEST OF TIMES IT WAS THE WORST OF TIMES
print(simple_columnar_decode("TREHINESETENIHGMAAESGTBEOED",9)) #THE TIME TO RISE HAS BEEN ENGAGED
print(simple_columnar_decode("LTIEFOHTEATETRYWTRHNHLDESTTDEDOSWHOWWN",5)) #LETS START WITH THE END OF THE WORLD WHY DONT WE
print(keyword_columnar_decode("OAOFEWIEHYHSOTRIASAEOVDUUSENHTNTRGUEWTSTRG","CRYPTO")) #OVER HEAD WITHOUT ANY FUSS THE STARS WERE GOING OUT
print(keyword_columnar_decode("UVENNNIRTGSATOITNOIOHEAVTEHLEHHGAEEONTNWSNNHN","DEFCABIGH")) #THE SUN SHONE HAVING NO ALTERNATIVE ON THE NOTHING NEW
print(keyword_columnar_decode('PEWEIRENNILPEDTQTDKLVIIJUHEPEEROOSAONYCF','DAEBC')) #UPON THE SIDEWALK PEOPLE IN EVERY DIRECTION (FQJ)
print(keyword_columnar_decode('RDELTTNRTSDMSSJKRTAESIEASTUETAEAOIA','FCEDBA')) #A MATTRESS AND A STEREO JUST LIKE I STARTED'''