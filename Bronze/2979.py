import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

a,b,c = map(int, sys.stdin.readline().split())

one = list(map(int, sys.stdin.readline().split()))
two = list(map(int, sys.stdin.readline().split()))
sam = list(map(int, sys.stdin.readline().split()))

cand = one + two + sam
plus = [one, two, sam]

commit = list(0 for i in range(max(cand)))# 0으로 초기화해서 크기가 max(cand)인 리스트 생성

for i in plus:
    for j in range(i[0],i[1]):
        commit[j] += 1
        
sum = 0

for i in commit:
    if i == 1:
        sum += 1*a
    elif i==2:
        sum += 2*b
    elif i==3:
        sum += 3*c
    
print(sum)