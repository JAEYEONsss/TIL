import sys
from collections import deque

def bfs(x,y):
    cal_x = [0,1,0,-1]
    cal_y = [1,0,-1,0]
    queue = deque([[0,0]])
    
    while queue:
        temp = queue.popleft()
        # visited.append(temp)
        for i in range(4):
            temp_x = temp[0]+cal_x[i]
            temp_y = temp[1]+cal_y[i]
            temp_list = [temp_x,temp_y]
            
            if temp_x<0 or temp_y<0 or temp_x >= n or temp_y >= m:
                continue
            if miro[temp_x][temp_y] == 0:
                continue
            if not weight[temp_x][temp_y] == 0:
                continue
            
            weight[temp_x][temp_y] = weight[temp[0]][temp[1]] + 1
            queue.append(temp_list)

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

n,m = map(int, sys.stdin.readline().split())

miro = [[] for _ in range(n)]
weight = [[0]*m for _ in range(n)]
# visited = []

for i in range(n):
    temp = sys.stdin.readline().replace('\n', '')
    for k in range(m):
        miro[i].append(int(temp[k]))
        
bfs(0,0)
print(weight[n-1][m-1]+1)

'''
최초, visited란 list를 만들어서 각 위치의 방문 여부를 체크했다.

if temp_list in visited 을 사용해서 방문 여부를 체크했다.

in을 사용하게 되면 list를 0~n까지 검사하기 때문에 시간 복잡도에서 오류가 발생했다.

따라서, 21번 째 줄처럼 논리를 변경했다.
'''