#part2
points = {}
current = 0,0
points[(0,0)] = 1
delta = 1
limit = 2 #number of times to do delta
temp = 0
val = 347991

def calculate(node):
  total = 0
  x, y = node
  pts = []
  pts.append((x, y+1))
  pts.append((x+1, y+1))
  pts.append((x+1, y))
  pts.append((x+1, y-1))
  pts.append((x, y-1))
  pts.append((x-1, y-1))
  pts.append((x-1, y))
  pts.append((x-1, y+1))
  for x in pts:
    if(x in points):
      total += points.get(x)
  points[node] = total
  return total


while(temp < val):
  if(delta % 2 == 1):
    for i in range(delta):
      current = current[0]+1, current[1]
      temp = calculate(current)
      if(temp > val):
        print(temp)
    for i in range(delta):
      current = current[0], current[1]+1
      calculate(current)
      if(temp > val):
        print(temp)
  else:
    for i in range(delta):
      current = current[0]-1, current[1]
      temp = calculate(current)
      if(temp > val):
        print(temp)
    for i in range(delta):
      current = current[0], current[1]-1
      calculate(current)
      if(temp > val):
        print(temp)
  delta += 1
    
    



  