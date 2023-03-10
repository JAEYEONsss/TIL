import sys

def dfs(f,s,g,u,d,visited):
    stack = []
    visited[s-1] = True
    stack.append(s)
    top = stack[-1]
    cnt = 0
    no_print = False
    
    while top != g and not no_print:
        up = top + u
        down = top - d
        
        if up > f:
            top = down
            if top <= 0:
                no_print = True
        elif down <= 0:
            if top > f:
                no_print = True
            top = up
        else:
            if abs(g-up) < abs(g-down):
                top = up
            else:
                top = down
                
        if visited[top-1] == True:
            no_print = True
            break
        
        visited[top-1] = True
        stack.append(top)
        cnt += 1
    
    if no_print:
        return "use the stairs"
    else:
        return cnt
        

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

f,s,g,u,d = map(int, sys.stdin.readline().split())
visited = [False for _ in range(f)]

print(dfs(f,s,g,u,d,visited))

'''
17, 20번 째 줄이 중요함

만일, 저기서 검사하지 않으면 top의 범위가 전체 층 밖이어도 추가 되어서 잘못된 결과를 야기
list는 [-1], [-2] 처럼 표기 가능이어서 top이 음수가 나와도 오류 발생이 안됨
'''