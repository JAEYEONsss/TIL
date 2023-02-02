import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

arr = [sys.stdin.readline().split() for _ in range(9)]    
    
num = list()

for i in range(9):
    num.append(int(arr[i][0]))
    
temp = sum(num)
check = False

for i in range(9):
    if check:
        break
    for j in range(i+1, 9):
        cand = temp - num[i] - num[j]
        if cand == 100:
            a = num[i]
            b = num[j]
            num.remove(a)
            num.remove(b)
            check =True
            break
        
num.sort()

for i in num:
    print(i)
    
'''
import itertools

array = [int(input()) for _ in range(9)]

for i in itertools.combinations(array, 7):  # 해당 배열을 7명 중복없이 뽑아준다.
    if sum(i) == 100:  # 그합이 100이라면
        for j in sorted(i):  # 그 7명을 오름차순으로 정렬후 출력한다.
            print(j)
        break #그 후 반복문 탈출
'''

# itertools 라이브러리를 사용해서 풀었으면 훨씬 단순했음