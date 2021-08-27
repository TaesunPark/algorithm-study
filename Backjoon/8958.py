N = int(input())

for i in range(N):
    Array = list(input())
    Sum = 0
    Point = 0
    for j in range(len(Array)):
        if Array[j] == 'O':
            Point += 1
        elif Array[j] == 'X':
            Point = 0
        Sum += Point
    print(Sum)

