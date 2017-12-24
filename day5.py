#part1
jmps = []

while True:
  line = input()
  if line:
    jmps.append(int(line))
  else:
    break
  
steps = 0
pos = 0
while pos < len(jmps) and pos >= 0:
  prev = pos
  pos += jmps[pos]
  jmps[prev] += 1
  steps += 1
print(steps)
#part2
import math
jmps = []

while True:
  line = input()
  if line:
    jmps.append(int(line))
  else:
    break

steps = 0
pos = 0
while pos < len(jmps) and pos >= 0:
  prev = pos
  pos += jmps[pos]
  if jmps[prev] > 2:
    jmps[prev] -= 1
  else:
    jmps[prev] += 1
  steps += 1
print(steps)