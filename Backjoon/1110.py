number = input()
number2 = int(number)
count = int(0)
sum1 = 0

if len(number) == 1:
    number = number + str(0)

while True:

    first = number[0]
    second = number[1]

    sum1 = (int(second) * 10) + (int(first) + int(second)) % 10

    count = count + 1
    number = str(sum1)

    if len(number) == 1:
        number = str(0) + number

    if sum1 == int(number2) and count > 1 and len(str(number2)) == 1:
        print(count-1)
        break
    elif sum1 == int(number2) and count > 1:
        print(count)
        break
