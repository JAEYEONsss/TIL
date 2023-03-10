import sys
from collections import deque

def bfs(n,m,x,y,head,matrix,clean):
    global cnt
    queue = deque()
    x_pos = [0, 1, 0, -1]
    y_pos = [-1, 0, 1, 0]
    queue.append((x,y))
    clean[x][y] = True
    cnt += 1
    
    while queue:
        now_x, now_y = queue.popleft()
        check = False
        for i in range(4):
            temp_x = now_x + x_pos[i]
            temp_y = now_y + y_pos[i]
            if temp_x < 0 or temp_y < 0 or temp_x >= n or temp_y >= m:
                continue
            if matrix[temp_x][temp_y] != 1:
                if not clean[temp_x][temp_y]:
                    check = True
                    clean[temp_x][temp_y] = True
                    cnt += 1
                    queue.append((temp_x,temp_y))
        if not check:
            if head == 0:
                now_x += 1
            elif head == 1:
                now_y -= 1
            elif head == 2:
                now_x -= 1
            else:
                now_y += 1
            if matrix[now_x][now_y] != 1 and not clean[now_x][now_y]:
                queue.append((now_x,now_y))
            

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

n,m = map(int, sys.stdin.readline().split())
x,y,head = map(int,sys.stdin.readline().split())
matrix = []
cnt = 0
clean = [[False for _ in range(m)] for _ in range(n)]

for _ in range(n):
    temp = list(map(int, sys.stdin.readline().split()))
    matrix.append(temp)
    
bfs(n,m,x,y,head,matrix,clean)
print(cnt)