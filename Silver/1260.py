import sys
from collections import deque

def dfs(start, graph, visited):
    visited[start-1] = True
    print(start, end= ' ')
    
    for i in graph[start]:
        if not visited[i-1]:
            dfs(i, graph, visited)

def bfs(start, graph, visited):
    queue = deque([start])
    visited[start-1] = True
    
    while queue:
        output = queue.popleft()
        print(output, end=' ')
        
        for i in graph[output]:
            if not visited[i-1]:
                queue.append(i)
                visited[i-1] = True
        
sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

vertex, line, start = map(int, sys.stdin.readline().split())
visited = [False]*vertex

graph = [[] for _ in range(vertex+1)]

for _ in range(line):
    top, fin = map(int, sys.stdin.readline().split())
    graph[top].append(fin)
    graph[fin].append(top)
    
for i in range(len(graph)):
    graph[i] = sorted(graph[i])
    
dfs(start, graph, visited)
print()
visited = [False]*vertex
bfs(start, graph, visited)
'''
dfs 알고리즘

1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.

2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문처리를 한ㄷ.
   방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
   
3. 2의 과정을 더 이상 수행할 수 없을 때까지 반복한다.

'''

'''
bfs 알고리즘

1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.

2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.

3. 2의 과정을 더 이상 수행할 수 없을 때까지 반복한다.
'''