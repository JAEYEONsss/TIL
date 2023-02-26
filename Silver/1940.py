import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

num = int(sys.stdin.readline())
target = int(sys.stdin.readline())
cnt = 0

stuff = list(map(int, sys.stdin.readline().split()))

for i in stuff:
    temp = target - i
    if temp in stuff:
        if temp == i:
            continue
        stuff.remove(temp)
        cnt += 1
        
print(cnt)