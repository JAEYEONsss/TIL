import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")
times = int(sys.stdin.readline())
stack = []

for i in range(times):
    line = sys.stdin.readline().strip()
    
    if 'push' in line:
        stack.append(line[5:])
    
    elif line == 'top':
        if len(stack) > 0:
            print(stack[-1])
        else:
            print(-1)
    
    elif line == 'empty':
        if len(stack) > 0:
            print(0)
        else:
            print(1)
    
    elif line == 'size':
        print(len(stack))
    
    else:
        if len(stack) > 0:
            print(stack[-1])
            stack.pop()
        else:
            print(-1)