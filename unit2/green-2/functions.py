alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
def caesar_encode(text, shift):
    return ''.join(alpha[(alpha.index(i)+shift)%26] for i in text)
def caesar_decode(text, shift):
    newString=''
    for i in text: 
        
        if alpha.index(i)-shift<0: newString+=alpha[alpha.index(i)-shift]  
        else: newString+=alpha[(alpha.index(i)-shift)%26]
    return newString
def caesar_crack(text):
    for i in range(26): print(caesar_decode(text.upper(),i))
def substitution_encode(text, code_alpha):
    return ''.join(code_alpha[alpha.index(i)] for i in text)
    
def substitution_decode(text, code_alpha):
    return ''.join(alpha[code_alpha.index(i)] for i in text)
caesar_crack('utajBdznWQtPpFeJoMsyLQrgbZVZgObGSqLFtS'.upper())
'''import sys
pt = sys.argv[1]
a2 = sys.argv[2]
ct = sys.argv[3]
ct2 = sys.argv[4]
shift = int(sys.argv[5])
print(caesar_encode(pt, shift))
print(caesar_decode(ct, shift))
print(substitution_encode(pt, a2))
print(substitution_decode(ct2, a2))
print(caesar_crack(ct))'''