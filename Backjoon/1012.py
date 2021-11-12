def dfs(i, j):
    if i >= M or i < 0 or j >= N or j < 0:
        return

    if graph[i][j] == 0:
        return

    graph[i][j] = 0
    dfs(i + 1, j)
    dfs(i, j + 1)
    dfs(i - 1, j)
    dfs(i, j - 1)


T = int(input())
for t in range(T):
    N, M, K = map(int, input().split())

    graph = [[0] * N for _ in range(M)]

    result = 0

    for _ in range(K):
        m1, m2 = map(int, input().split())
        graph[m2][m1] = 1

    for i in range(M):
        for j in range(N):
            if graph[i][j] == 1:
                dfs(i, j)
                result += 1

    print(result)