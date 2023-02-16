import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

day,cont = map(int, sys.stdin.readline().split())
cal = list(map(int, sys.stdin.readline().split()))
start = 0
temp = sum(cal[:cont])
high = temp

for i in range(cont, len(cal)):
    temp = temp - cal[start] + cal[i]
    high = max(temp, high)
    start+=1

print(high)