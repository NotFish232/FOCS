import sys
s=sys.argv[1]
print('#1:',s[2])
print('#2:',s[4])
print('#3:',len(s))
print('#4:',s[0])
print('#5:',s[-1])
print('#6:',s[-2])
print('#7:',s[3:8])
print('#8:',s[-5:])
print('#9:',s[3:])
print('#10:',s.lower())
print('#11:',s.upper())
listthing=[]
for i in s:
    listthing+=i
print('#12:',listthing)
print('#13:',s[:-1])
print('#14:',s[1:])
eCounter=0
for i in s:
    if i=='e': eCounter+=1
print('#15:',eCounter)
eCounter=0
for i in s:
    if i.lower=='e': eCounter+=1
print('#16:',eCounter)
vowelCounter=0
for i in s:
    if i.lower()=='e' or i.lower()=='u' or i.lower()=='o' or i.lower()=='i' or i.lower()=='a': vowelCounter+=1
print('#17:',vowelCounter)
newList=[]
for i in s:
    if i.lower()=='e' or i.lower()=='u' or i.lower()=='o' or i.lower()=='i' or i.lower()=='a': newList+=i
print('#18:',newList)
print('#19:',s[::2])
print('#20:',s[1::2])
newList=[]
for i in range(len(s)-1):
    newList.append(s[i:i+2])
print('#21:',newList)
newString=''
for i in range(len(s)):
    if i%3==0: newString+='!'
    else: newString+=s[i]
print('#22:',newString)
newString=''
for i in range(len(s)):
    if (i+1)%3==0: newString+='!'
    else: newString+=s[i]
print('#23:',newString)