n = int(input())
for i in range(n):
    a, b, c = map(int, input().split())
    if c % a == 0:
        room = c // a
    else:
        room = c // a + 1

    floor = c - ((c // a) * a)
    if floor == 0:
        floor = a
    if room < 10:
        print(floor, 0, room, sep="")
    else:
        print(floor, room, sep="")