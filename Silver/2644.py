import sys
from collections import deque

def bfs(start, jokbo, visited, distance):
    queue = deque([start])
    
    while queue:
        v = queue.popleft()
        for i in jokbo[v]:
            if not visited[i-1]:
                visited[i-1]=True
                queue.append(i)
                distance[i] = distance[v] + 1

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

fam = int(sys.stdin.readline())
start, fin = map(int, sys.stdin.readline().split())
line = int(sys.stdin.readline())

jokbo = [[] for _ in range(fam+1)]
visited = [False]*fam
distance = [0]*(fam+1)

for _ in range(line):
    parent, child = map(int, sys.stdin.readline().split())
    jokbo[parent].append(child)
    jokbo[child].append(parent)

bfs(start, jokbo, visited, distance)

if distance[fin] > 0:
    print(distance[fin])
else:
    print(-1)