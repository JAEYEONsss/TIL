import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

moeum = ['a', 'e', 'i', 'o', 'u']
third_sample = ['ee', 'oo']
word = sys.stdin.readline().replace('\n', '')

while word != 'end':
    essential = False
    same = False
    size = False
    before = ''
    stack = list()
    
    for i in word:
        if before != '':
            if before in moeum and i not in moeum:
                stack = []
            elif before not in moeum and i in moeum:
                stack = []
                
        stack.append(i)
        
        if i in moeum:
            essential = True
        
        if before == i:
            if (before + i) not in third_sample:
                same = True
            
        if len(stack) >= 3:
            size = True
        
        before = i
    
    if essential and not same and not size:
        print("<%s> is acceptable." %word)
    else:
        print("<%s> is not acceptable." %word)
        
    word = sys.stdin.readline().replace('\n', '')

'''
자음과 모음이 변경될 때 스택을 비운다
스택의 길이가 3이상이면 x
third_sample에 나온 문자열을 제외하고 연속된 문자가 나오면 x
'''