def bad_fib(n):
    #this is bad because it calls for 2^n calls while the other method calls for n calls
    if n==0 or n==1: return 1
    return bad_fib(n-2)+bad_fib(n-1)

def fib_helper(n, prev, cur):
    if n == 0: return cur
    return fib_helper(n-1,cur,prev+cur)

def fib(n):
    return fib_helper(n, 0, 1)

def is_fib(n,counter=0):
    if (n==fib(counter)): return True
    if (fib(counter)>n): return False
    return is_fib(n,counter+1)

def sum_even_fib(n,x=0):
    if fib(x)>=n: return 0
    if fib(x)%2==0: return fib(x)+sum_even_fib(n,x+1)
    return sum_even_fib(n,x+1)
    
import sys
print(is_fib(int(sys.argv[1])))
print(sum_even_fib(int(sys.argv[2])))