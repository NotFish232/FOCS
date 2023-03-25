def listHelp(text,thing):
    list=[]
    with open(text) as file:
        for line in file:
            line=line.strip().replace(' ','')
            if '-' in line: list.append(line)
            elif '/' in line:
                temp=line[line.index('/')+1:].index('/')+line.index('/')+1
                if int(line[temp+1:])>21: 
                    year='19'+line[temp+1:]
                else: 
                    year='20'+line[temp+1:]
                if line.index('/')==1: month='0'+line[:line.index('/')]
                else: month=line[:line.index('/')]
                if len(line[line.index('/')+1:temp])==1: list.append(year+'-'+month+'-'+'0'+line[line.index('/')+1:temp])
                else: list.append(year+'-'+month+'-'+line[line.index('/')+1:temp])
            else:
                if 'January' in line:
                    line=line.replace('January','')
                    month='01'
                if 'February' in line:
                    line=line.replace('February','')
                    month='02'
                if 'March' in line:
                    line=line.replace('March','')
                    month='03'
                if 'April' in line:
                    line=line.replace('April','')
                    month='04'
                if 'May' in line:
                    line=line.replace('May','')
                    month='05'
                if 'June' in line:
                    line=line.replace('June','')
                    month='06'
                if 'July' in line:
                    line=line.replace('July','')
                    month='07'
                if 'August' in line:
                    line=line.replace('August','')
                    month='08'  
                if 'September' in line:
                    line=line.replace('September','')
                    month='09'
                if 'October' in line:
                    line=line.replace('October','')
                    month='10'
                if 'November' in line:
                    line=line.replace('November','')
                    month='11'
                if 'December' in line:
                    line=line.replace('December','')
                    month='12'
                if len(line[0:line.index(',')])==1: list.append(line[line.index(',')+1:]+'-'+month+'-'+'0'+line[0:line.index(',')])
                else: list.append(line[line.index(',')+1:]+'-'+month+'-'+line[0:line.index(',')])
    list=sorted(list)
    with open(thing, "w") as file:
        for date in list:
            file.write(date+'\n')
import sys
listHelp(sys.argv[1],sys.argv[2])