def sequence(number):
    a = list(str(number))
    if int(a[0]) - int(a[1]) == int(a[1]) - int(a[2]):
        return 1
    else:
        return 0


Num = int(input())
count = 0

if Num < 100:
    count = Num
else:
    count = 99
    for i in range(100, Num + 1):
        if i == 1000:
            break
        if sequence(i):
            count = count + 1

print(count)
