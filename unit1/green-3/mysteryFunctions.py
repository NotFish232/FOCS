def mysteryA(x):
  return x%2==0 or x%3==0
def mysteryB(x):
  if x<10: return x%2==0
  return True
def mysteryC(x):
  return x%3!=0
def mysteryD(x):
  if x<=3: return True
  if x<=9: return False
  return True
def mysteryE(x):
  return x%3!=5 or x%3!=3
def mysteryF(x):
  if x<=4: return False
  if x<=9: return True
  return False

def cigar_party(cigars, is_weekend):
  return (not is_weekend and cigars>= 40 and cigars<=60) or (is_weekend and cigars>=40)
def date_fashion(you, date):
  if you<=2 or date<=2: return 0
  if you>=8 or date>8: return 2
  return 1
def squirrel_play(temp, is_summer):
  return (temp>=60 and temp<=90) or (is_summer and temp>=60 and temp<=100)
def caught_speeding(speed, is_birthday):
  birthday=0
  if is_birthday:birthday=5
  if speed>=85+birthday: return 2
  if 61+birthday<=speed<=80+birthday: return 1
  return 0
def sorta_sum(a, b):
  if a+b>=10 and a+b<=19: return 20
  return a+b
def alarm_clock(day, vacation):
  if vacation:
    if day==0 or day==6: return "off"
    return "10:00"
  if day==0 or day==6: return "10:00"
  return "7:00"
def love6(a, b):
  return a==6 or b==6 or a+b==6 or abs(a-b)==6
def in1to10(n, outside_mode):
  if outside_mode: return n<=1 or n>=10
  return 1<=n<=10
def near_ten(num):
  return num%10<=2 or num%10>=8