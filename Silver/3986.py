import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

num = int(sys.stdin.readline())
out = 0

for i in range(num):
    stack = [0]
    for j in sys.stdin.readline().replace('\n', ''):
        if stack[-1] == j:
            stack.pop()
        else:
            stack.append(j)
    if len(stack) == 1:
        out += 1
print(out)

'''
괄호 여닫는 문제와 동일하게 접근한다.
스택에 마지막에 있는 문자가 내가 검사하고 있는 문자와 동일하면 pop
반대의 경우에는 내가 검사하고 있는 문자를 push
한 문자열에 대해서 반복문이 종료되고 stack에 0만 남아있으면 좋은단어
아니면 나쁜 단어
'''