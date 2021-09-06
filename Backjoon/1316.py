N = int(input())
for _ in range(N):
    Str = input().rstrip()
    for i in range(len(Str)-1):
        if Str[i] != Str[i+1]:
            if Str[i] in Str[i+1:]:
                N -= 1

print(N)
