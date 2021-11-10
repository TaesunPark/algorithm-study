num = []


def dfs(x, y):
    if x >= N or x < 0 or y >= N or y < 0:
        return False
    if graph[x][y] == 1:
        global count
        count += 1
        graph[x][y] = 0
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
        return True
    else:
        return False


N = int(input())
count = 0
result = 0
graph = []

for i in range(N):
    x = list(map(int, input()))
    graph.append(x)

for i in range(N):
    for j in range(N):
        if dfs(i, j):
            num.append(count)
            count = 0
            result += 1
num.sort()
print(result)
for i in range(result):
    print(num[i])
