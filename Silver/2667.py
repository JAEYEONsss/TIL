import sys

def dfs(x,y):
    x_pos = [-1, 0, 1, 0]
    y_pos = [0, 1, 0, -1]
    
    for i in range(4):
        global cnt
        temp_x = x+x_pos[i]
        temp_y = y+y_pos[i]
        
        if temp_x < 0 or temp_y < 0 or temp_x >= time or temp_y >= time:
            continue
        if visited[temp_x][temp_y] != 0 or graph[temp_x][temp_y] != 1:
            continue
        
        visited[temp_x][temp_y] += 1
        cnt += 1
        dfs(temp_x,temp_y)
    

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

time = int(sys.stdin.readline())
graph = [[] for _ in range(time)]
visited = [[0 for _ in range(time)] for _ in range(time)]
danzi = []
cnt = 0

for i in range(time):
    cont = sys.stdin.readline().rstrip()
    for j in range(time):
        graph[i].append(int(cont[j]))

for x in range(time):
    for y in range(time):
        if graph[x][y] == 1 and visited[x][y] == 0:
            dfs(x,y)
            if cnt == 0:
                cnt+=1
            danzi.append(cnt)
            cnt = 0
    
danzi = sorted(danzi)

print(len(danzi))
for i in range(len(danzi)):
    print(danzi[i])