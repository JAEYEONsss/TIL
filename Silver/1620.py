import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

num, sol = map(int, sys.stdin.readline().split())
book = dict()

for i in range(num):
    book[i+1] = sys.stdin.readline().replace("\n", "")
  
reverse_book = dict(map(reversed,book.items()))
                    
for i in range(sol):
    test = sys.stdin.readline().replace("\n", "")
    if test.isdigit():
        print(book[int(test)])
    else:
        print(reverse_book[test])