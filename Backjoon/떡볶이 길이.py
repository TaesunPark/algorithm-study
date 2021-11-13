N, M = list(map(int, input().split(' ')))
d_list = list(map(int, input().split()))

start = 0
result = 0
end = max(d_list)

while start <= end:
    total = 0
    mid = (start + end) // 2

    for x in d_list:
        if mid < x:
            total += x - mid
    if total < M:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)
