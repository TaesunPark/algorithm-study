tmp = 1
cnt = 0
d = 6
number = int(input())

while number > tmp:
        cnt = cnt + 1
        tmp += d
        d += 6

print(cnt+1)