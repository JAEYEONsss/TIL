import sys
from collections import deque

def bfs(limit, x, y, check):
    queue = deque([(x,y)])
    check[x][y] = 1
    
    while queue:
        org_x, org_y = queue.popleft()
        
        for i in range(4):
            temp_x = org_x + x_pos[i]
            temp_y = org_y + y_pos[i]
            
            if temp_x < 0 or temp_y < 0 or temp_x >= size or temp_y >= size:
                continue
            if matrix[temp_x][temp_y] > limit and check[temp_x][temp_y] != 1:
                check[temp_x][temp_y] = 1
                queue.append((temp_x,temp_y))
            
    
sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

size = int(sys.stdin.readline())

matrix = []
max_height = 0

x_pos = [-1,0,1,0]
y_pos = [0,1,0,-1]

result = 0

for i in range(size):
    temp = list(map(int, sys.stdin.readline().split()))
    matrix.append(temp)
    max_height = max(max_height, max(temp))

for limit in range(max_height):
    check = [[0 for _ in range(size)] for _ in range(size)]
    cnt = 0
    for x in range(size):
        for y in range(size):
            if matrix[x][y] > limit and check[x][y] == 0:
                bfs(limit, x, y, check)
                cnt += 1
    
    if result < cnt:
        result = cnt

print(result)