import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")
time = int(sys.stdin.readline())
ptn = sys.stdin.readline()
head = ''
tail = ''
chg = True

num = 0

while True:
    if ptn[num] == '\n':
        break
    
    if ptn[num] == '*':
        num += 1
        chg = not chg
    
    if chg:
        head += ptn[num]
        
    else:
        tail += ptn[num]
        
    num += 1

for i in range(time):
    test = sys.stdin.readline().replace("\n", "")
    
    if len(test) < len(head+tail):
        print("NE")
        continue
    
    if test[:len(head)] == head:
        if test[-len(tail):] == tail:
            print("DA")
            continue
    print("NE")