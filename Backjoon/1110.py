number = int(input())
value = number
count = int(0)

while True:
    first = number % 10
    second = number // 10
    third = first + second
    number = first * 10 + third % 10
    count = count + 1

    if value == number:
        print(count)
        break
