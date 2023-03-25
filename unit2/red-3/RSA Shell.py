import math
from random import randint
from sympy import nextprime
alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def mod_inverse_helper(a, b):
    q, r = a//b, a%b
    if r == 1:
        return (1, -1 * q)
    u, v = mod_inverse_helper(b, r)
    return (v, -1 * q * v + u)

def mod_inverse(a, m):
    assert math.gcd(a, m) == 1, "You're trying to invert " + str(a) + " in mod " + str(m) + " and that doesn't work!"
    return mod_inverse_helper(m, a)[1] % m

def get_d(p,q,e):
    return mod_inverse(e,(p-1)*(q-1))

def convert_to_num(ngraph):
    return sum(alpha.index(ngraph[i])*26**i for i in range(len(ngraph)))

def convert_to_text(num,n):
    if n==0: return ''
    return alpha[num%26]+convert_to_text(num//26,n-1)

def rsa_encode(text,m,e):
    assert convert_to_num(text)<m, "You are trying to encode" + text + "in mod" + m + "and that doesn't work!"
    return pow(convert_to_num(text),e,m)

def rsa_decode(num,m,d,size):
    return convert_to_text(pow(num,d,m),size)

def make_prime(n):
    return nextprime(randint(2**(n-1),2**n))

import sys
text = sys.argv[1]
p, q, e, dec_rsa, dec_rsa_l = [int(x) for x in sys.argv[2:]]
m = p * q
d = get_d(p, q, e)
print(d)
print(rsa_encode(text, m, e))
print(rsa_decode(dec_rsa, m, d, dec_rsa_l))