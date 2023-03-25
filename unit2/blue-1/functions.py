def vigenere_encode(message,key,newString='',alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'):
    return ''.join(alpha[(alpha.index(message[i])+alpha.index(key[i%len(key)]))%26] for i in range(len(message)))
def vigenere_decode(message,key,newString='',alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'):
    return ''.join(alpha[(alpha.index(message[i])-alpha.index(key[i%len(key)]))] for i in range(len(message)))
import sys
pt = sys.argv[1]
ct = sys.argv[2]
ky = sys.argv[3]
print(vigenere_encode(pt, ky))
print(vigenere_decode(ct, ky))