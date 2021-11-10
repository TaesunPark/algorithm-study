result = -1

def dfs(start_v, visited = []):
	visited.append(start_v)
	global result
	result += 1
	for w in range(len(graph[start_v])):
		if graph[start_v][w] == 1 and (w not in visited):
			dfs(w)


N = int(input())
M = int(input())

graph = [[0] * (N+1) for _ in range(N+1)]


for i in range(M):
	m1, m2 = map(int, input().split())
	graph[m1][m2] = 1
	graph[m2][m1] = 1

dfs(1) # depth-first-search
print(result)