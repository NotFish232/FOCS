def malcom(x):
  return 2*x+1

def carol(y):
  if y<0:
    return 0
  return y

def elaisa(x, y):
  return 2*x-y

def akash(a):
  if a>0: 
    return 1
  return -1

def rosa(x):
  return -1*malcom(x-1)

def aashni(q):
  return q*akash(q)

def dion(n):
  if (n>10):
    return malcom(n)
  return rosa(n)

def zhixing(a, b):
  return 2*(elaisa(aashni(a),rosa(b)))