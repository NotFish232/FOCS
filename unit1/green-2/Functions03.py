# Just like before, dummy return statements have been added to each function.  Delete each return statement
# and complete the function as specified on the problem set.
# DO NOT FORGET to USE PRINT STATEMENTS to TEST YOUR CODE!
def mystery1(x):
  return -3*x


def mystery2(x):
  return x+7


def mystery3(x):
  return 2*x-1


def mystery4(x, y):
  return x-y

def rec(n):
  if n == 0: return 1
  else: return 3 + rec(n - 1)

def mystery5(x):
  if x<0:
    return 2*x
  return 1000000


def mystery6(x):
  return x*x-2

def mystery7(x, y):
  if x>0: return x
  return y


def mystery8(x):
  if (x%2==0): return 0
  return 19


def mystery9(x):
  if (x%2==1): return -1
  return x*2


def mystery10(x, y):
  return 5*max(x,y)

def mystery11(x):
  if (x%2==0): return x/2
  return x*3+1


def mystery12(x):
  return x//3
def rec2(x):
  if x == 0:return 1
  else:return 2 * rec2(x - 1)