reg_dict = {}

max_ = 0
	
def doOperation(op_, sign_, delta_):
  if sign_ == "inc":
    reg_dict[op_] = reg_dict[op_] + int(delta_)
    return reg_dict[op_]
  if sign_ == "dec":
    reg_dict[op_] = reg_dict[op_] - int(delta_)
    return reg_dict[op_]

while True:
	line = input()
	if line:
	  op1, sign, delta, if_, op2, cond, bound = line.split(' ');
	  if op1 not in reg_dict:
	    reg_dict[op1] = 0
	  if op2 not in reg_dict:
	    reg_dict[op2] = 0
	  if cond == "<":
	    if reg_dict[op2] < int(bound):
	      temp = doOperation(op1, sign, delta)
	      if temp > max_:
	        max_ = temp
	  elif cond == ">":
	    if reg_dict[op2] > int(bound):
	      temp = doOperation(op1, sign, delta)
	      if temp > max_:
	        max_ = temp
	  elif cond == "==":
	    if reg_dict[op2] == int(bound):
	      temp = doOperation(op1, sign, delta)
	      if temp > max_:
	        max_ = temp
	  elif cond == ">=":
	    if reg_dict[op2] >= int(bound):
	      temp = doOperation(op1, sign, delta)
	      if temp > max_:
	        max_ = temp
	  elif cond == "<=":
	    if reg_dict[op2] <= int(bound):
	      temp = doOperation(op1, sign, delta)
	      if temp > max_:
	        max_ = temp
	  elif cond == "!=":
	    if reg_dict[op2] != int(bound):
	      temp = doOperation(op1, sign, delta)
	      if temp > max_:
	        max_ = temp
	else:
	  break
print(max(list(reg_dict.values()))) #part1
print(max_) #part2
