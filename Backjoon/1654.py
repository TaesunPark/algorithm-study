N, M = list(map(int, input().split(' ')))
d_list = []

for i in range(N):
    d_list.append(int(input()))

if 0 in d_list:
    d_list.remove(0)

d_list.sort()
start = 1
result = 0
end = max(d_list)

while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in d_list:
        count += (i // mid)
    if count >= M:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)

