def gcd(x,y):
    return gcdHelper(x,y,min(x,y))

def gcdHelper(x,y,f):
    if (x%f==0 and y%f==0): return f
    return gcdHelper(x,y,f-1)

def gcd_euclid(x,y):
    if y==0: return x
    return gcd_euclid(y,x%y) 

def lcm(x,y):
    return int(x*y/gcd_euclid(x,y))

def lcm_n(n):
    if (n==1): return 1
    return lcm(n,lcm_n(n-1))
    
import sys
x = int(sys.argv[1])
y = int(sys.argv[2])
n = int(sys.argv[3])
print(gcd(x, y))
print(gcd_euclid(x, y))
print(lcm(x, y))
print(lcm_n(n))
