data = input()

stack = []
layer = 0
total = 0
garbage = False
numGarbage = 0
i = 0
while i < len(data):
  if garbage == True:
    if data[i] == '!':
      i += 1
    elif data[i] == '>':
      garbage = False
    else:
      numGarbage += 1
      i += 1
      continue
  else:
    if data[i] == '!':
      i += 1
    if data[i] == '<':
      garbage = True
    if data[i] == ',':
      i += 1
      continue
    if data[i] == '{':
      stack.append(data[i])
      layer += 1
    if data[i] == '}':
      stack.pop()
      total += layer
      layer -= 1
  i += 1
print(total) #part1
print(numGarbage) #part2