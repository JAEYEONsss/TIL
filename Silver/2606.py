import sys

def check_virus(graph, node_num, visited):
    virus.append(node_num)
    visited[node_num-1] = True
    
    for i in graph[node_num]:
        if not visited[i-1]:
            check_virus(graph, i, visited)

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

node = int(sys.stdin.readline())
line = int(sys.stdin.readline())
visited = [False]*node
graph = [[] for _ in range(node + 1)]
virus = []

for i in range(line):
    top, bottom = map(int, sys.stdin.readline().split())
    graph[top].append(bottom)
    graph[bottom].append(top)
    
check_virus(graph, 1, visited)
virus.remove(1)
print(len(virus))