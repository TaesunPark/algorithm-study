from collections import deque

result = -1

def bfs(start_v):
	global result
	visited = [start_v]
	queue = deque()
	queue.append(start_v)

	while queue:
		v = queue.popleft()
		result += 1
		for w in range(len(graph[v])):
			if graph[v][w] == 1 and (w not in visited):
				queue.append(w)
				visited.append(w)


N = int(input())
M = int(input())

graph = [[0] * (N+1) for _ in range(N+1)]


for i in range(M):
	m1, m2 = map(int, input().split())
	graph[m1][m2] = 1
	graph[m2][m1] = 1

bfs(1) # depth-first-search
print(result)