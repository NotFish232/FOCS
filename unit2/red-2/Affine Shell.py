import sys
import math

alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"


def mod_inverse_helper(a, b):
    q, r = a//b, a % b
    if r == 1:
        return (1, -1 * q)
    u, v = mod_inverse_helper(b, r)
    return (v, -1 * q * v + u)


def mod_inverse(a, m):
    assert math.gcd(a, m) == 1, "You're trying to invert " + \
        str(a) + " in mod " + str(m) + " and that doesn't work!"
    return mod_inverse_helper(m, a)[1] % m


def affine_encode(string, a, b):
    return ''.join(alpha[(a*alpha.index(i)+b) % 26] for i in string)


def affine_decode(string, a, b):
    return ''.join(alpha[(mod_inverse(a, 26)*(alpha.index(i)-b)) % 26] for i in string)


def convert_to_num(ngraph):
    return sum(alpha.index(ngraph[i])*26**i for i in range(len(ngraph)))


def convert_to_text(num, n):
    if n == 0:
        return ''
    return alpha[num % 26]+convert_to_text(num//26, n-1)


def affine_n_encode(text, n, a, b):
    text +='X'*(n-len(text) % n)
    return ''.join(convert_to_text((a*convert_to_num(text[i:i+n])+b) % (26**n), n) for i in range(0, len(text), n))


def affine_n_decode(text, n, a, b):
    text+=' '*(n-len(text)%n)
    return ''.join(convert_to_text((mod_inverse(a, 26**n)*(convert_to_num(text[i:i+n])-b)), n) for i in range(0, len(text), n))


print(affine_n_encode('THEQUICKBROWNFOXJUMPEDOVERTHELAZYDOG', 5, 347, 1721))
text, dec1, dec2 = sys.argv[1:4]
a, b, n, n_a, n_b = [int(x) for x in sys.argv[4:]]
print(affine_encode(text, a, b))
print(affine_decode(dec1, a, b))
print(affine_n_encode(text, n, n_a, n_b))
print(affine_n_decode(dec2, n, n_a, n_b))
