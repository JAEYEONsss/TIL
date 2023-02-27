import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

screen_size, box_size = map(int, sys.stdin.readline().split())

start = 0
fin = box_size
distance = 0

for i in range(int(sys.stdin.readline())):
    pos = int(sys.stdin.readline())
    
    while not (start < pos and fin >= pos):
        if pos >= fin:
            start += 1
            fin += 1
            distance += 1
        else:
            start -= 1
            fin -= 1
            distance += 1

print(distance)