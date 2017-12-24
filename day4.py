#part1
import collections

total = 0

while True:
  line = input()
  if line:
    ct = collections.Counter()
    li = line.split()
    for phrase in li:
      ct[phrase] += 1
      if(len(list(ct)) == len(li)):
        total += 1
  else:
    break
  
print(total)
#part2
import collections

total = 0

while True:
  line = input()
  if line:
    ct = collections.Counter()
    li = line.split()
    sorted_li = []
    for phrase in li:
      sorted_li.append(''.join(sorted(phrase)))
    for phrase in sorted_li:
      ct[phrase] += 1
      if(len(list(ct)) == len(li)):
        total += 1
  else:
    break
  
print(total)