N = int(input())
for i in range(N):
    M, Str = input().split()
    tmp = ""
    for j in list(Str):
        tmp += j * int(M)
    print(tmp)
