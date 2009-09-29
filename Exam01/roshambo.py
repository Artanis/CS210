def compare (a, b):
    result = ""
    
    if(a == b): result = 3
    elif(a+1 if a+1 <= 2 else 0) == b: result = b
    else: result = a
    
    return result

names = ["Scissors", "Rock", "Paper", "Draw"]

for i in [0,1,2]:
    for j in [0,1,2]:
        win = compare(i,j)
        print "%s vs. %s - %s" % (names[i], names[j], names[win])
