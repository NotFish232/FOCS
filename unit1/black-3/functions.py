def sort_string(string):
    if len(string)==1: return string
    return sort_string_helper(string)[0]+sort_string(string[:sort_string_helper(string)[1]]+string[sort_string_helper(string)[1]+1:])

def sort_string_helper(string,index=0,lowest=['z',0]):
    if (index==len(string)): return lowest 
    if (string[index]<=lowest[0]): lowest=[string[index],index]
    return sort_string_helper(string,index+1,lowest)

def reverse_sort_string(string):
    if (len(string)==1): return string
    return reverse_sort_string(string[:sort_string_helper(string)[1]]+string[sort_string_helper(string)[1]+1:])+sort_string_helper(string)[0]

def vowels_first(string):
   return sort_string(getAllVowels(string,True))+sort_string(getAllVowels(string,False))
   
def getAllVowels(string,yes):
    if (len(string)==0): return ''
    if (string[0]=='a' or string[0]=='i' or string[0]=='e' or string[0]=='o' or string[0]=='u'): 
        if (yes): return string[0]+getAllVowels(string[1:],yes)
        return getAllVowels(string[1:],yes)
    if (yes): return getAllVowels(string[1:],yes)
    return string[0]+getAllVowels(string[1:],yes)
    
import sys
print(sort_string(sys.argv[1]))
print(reverse_sort_string(sys.argv[1]))
print(vowels_first(sys.argv[1]))