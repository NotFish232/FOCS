def mult_3_5(n):
    return  n % 3 == 0 or n%5==0
def sum_no_3_5(n):
    if n == 0: return 0
    if  not mult_3_5(n): return n + sum_no_3_5(n - 1)
    return sum_no_3_5(n - 1)
def ends_with_1_or_3(n):
    return n%10==1 or n%10==3
def sum_ends_1_or_3(n):
    if n==0: return 0
    if ends_with_1_or_3(n): return n+sum_ends_1_or_3(n-1)
    return sum_ends_1_or_3(n-1)
def odd_number_digits(n):
    count=0
    while(n>0):
        n=n//10
        count+=1
    return count%2==1
def sum_odd_digits(n):
    if n==0: return 0
    if odd_number_digits(n): return n+sum_odd_digits(n-1)
    return sum_odd_digits(n-1)
import sys
print(sum_no_3_5(int(sys.argv[1])))
print(ends_with_1_or_3(int(sys.argv[2])))
print(sum_ends_1_or_3(int(sys.argv[3])))
print(odd_number_digits(int(sys.argv[4])))
print(sum_odd_digits(int(sys.argv[5])))