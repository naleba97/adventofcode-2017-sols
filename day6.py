#part1
banks = []
cache = []
x = []
count = 0

banks = list(map(int, input().split("\t")))
cache.append(list(banks))
while(x not in cache):
  cache.append(list(x))
  max_ = max(banks)
  pos_ = banks.index(max_)
  banks[pos_] = 0
  pos_ += 1
  while max_ != 0:
    if(pos_ == len(banks)):
      pos_ = 0
    banks[pos_] += 1
    pos_ += 1
    max_ -= 1
  x = banks
  count += 1
print(count)
#part2
banks = []
cache = {}
x = ()
count = 0
cycles = 0

banks = list(map(int, input().split("\t")))
cache[tuple(list(banks))] = cycles
while(x not in cache):
  cache[tuple(list(x))] = cycles
  max_ = max(banks)
  pos_ = banks.index(max_)
  banks[pos_] = 0
  pos_ += 1
  while max_ != 0:
    if(pos_ == len(banks)):
      pos_ = 0
    banks[pos_] += 1
    pos_ += 1
    max_ -= 1
  x = tuple(banks)
  cycles += 1
  count += 1
print(len(cache) - int(cache[tuple(list(x))]) - 1)

  

