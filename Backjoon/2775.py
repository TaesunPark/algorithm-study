n = int(input())

for i in range(n):
    floor = int(input())
    room = int(input())
    List = [x for x in range(1, room+1)]

    for k in range(floor):
        for j in range(1, room):
            List[j] += List[j-1]
    print(List[-1])