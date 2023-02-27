import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

msg_len, num_lim = map(int, sys.stdin.readline().split())
numbers = list(map(int, sys.stdin.readline().split()))
num_book = dict()

for i in numbers:
    if not i in num_book:
        num_book[i] = 0
    num_book[i] += 1
    
num_book = dict(sorted(num_book.items(), key=lambda x:x[1], reverse=True))

for i in num_book:
   for j in range(num_book[i]):
       print(i, end=' ')

'''
문제 조건: 출력 빈도가 동일하면 나온 순서대로 출력하라

문제 풀이: 출력 빈도가 동일하면 정렬할 때, 나온 순서대로 정렬되어서 다른 처리를 하지 않아도 된다.
'''