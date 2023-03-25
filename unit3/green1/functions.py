file='green1/data_short.txt'
def findMedian(list):
    return list[len(list)//2] if len(list)%2==1 else (list[len(list)//2]+list[len(list)//2-1])/2
list=sorted([float(line.strip()) for line in open(file)])
print('Average: ',sum(list)/len(list))
print('Min: ',min(list))
print('Q1: ',findMedian(list[:len(list)//2]))
print('Median: ',findMedian(list))
print('Q3: ',findMedian(list[len(list)//2+1:]) if len(list)%2==1 else findMedian(list[len(list)//2:]))
print('Max: ',max(list))
print('Sorted list: ',list)