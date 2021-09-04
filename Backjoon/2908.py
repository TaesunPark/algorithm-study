a, b = list((input().split()))
c = []
d = []

for i in range(3):
    c.append(a[2-i])
    d.append(b[2-i])


if int("".join(c)) > int("".join(d)):
    print(int("".join(c)))
else:
    print(int("".join(d)))
