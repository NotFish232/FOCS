list = []
times = []
with open('ch24.txt') as file:
    for line in file:
        line = line.strip()
        list.append(
            sorted([int(i) for i in line[1:line.index(']')].replace(',', '').split()]))
        # removes commas, sorts numbers, and turns it into an array
        # gets time solved per set
        times.append(float(line[line.index(']')+2:]))
length = len(list)
cardFreq = []
while len(list) > 0:
    current = list[0]
    count = 0
    while current in list:
        list.remove(current)
        count += 1
    count = str(count)
    if len(str(count)) == 1:
        count = '0'+count
    cardFreq.append(count+str(current))
    # find duplicates and appends them to new array, with count as first index and then card set
cardFreq = sorted(cardFreq)[::-1]
index = 0
sorted = []
while index < len(cardFreq):
    frequency = cardFreq[index][:2]
    row = ''
    while index < len(cardFreq) and cardFreq[index][:2] == frequency:
        # while same frequency, append to same row
        if row.count('[') % 5 == 0:
            row += '\n'  # breaks line every 5 sets
        row += '  '+cardFreq[index][2:]
        index += 1
    sorted.append(str(frequency)+' (times ocurred): ' +
                  str(row.count('['))+' (sets)\n'+row)
    # each element in 'sorted' is a frequency followed by a list of all sets with that frequency
with open("cards.txt", "w") as file:
    import time
    # prints a bunch of data about the card sets solved
    minutes, seconds = divmod(round(sum(times)), 60)
    hours, minutes = divmod(minutes, 60)
    file.write('---------------------------\n')
    file.write('Last sync: '+str(time.strftime('%I:%M %p, %m/%d/%y',
               time.localtime(time.time())))+'\n')
    file.write('Time spent: {} hr {} min\n'.format(hours, minutes))
    file.write('Average time: {} sec\n'.format(round(sum(times)/length, 2)))
    file.write('Quickest time: {} sec\n'.format(min(times)))
    file.write('Slowest time: {} sec\n'.format(max(times)))
    file.write('Number of sets solved: {}\n'.format(length))
    file.write('Number of unique sets: {}\n'.format(len(cardFreq)))
    file.write('---------------------------\n')
    [file.write('\n'+i+'\n') for i in sorted]  # prints each element in sorted
