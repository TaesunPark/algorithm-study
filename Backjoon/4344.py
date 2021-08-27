N = int(input())

for _ in range(N):
    Array = list(map(int, input().split()))
    avg = sum(Array[1:]) / Array[0]
    cnt = 0
    for i in Array[1:]:
        if avg < i:
            cnt += 1
    per = (cnt / Array[0]) * 100
    print('%.3f' % per + '%')
