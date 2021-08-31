List = list(input())
all_list = [-1 for i in range(26)]
for i in range(26):
    for j in List:
        if j == chr(i+97):
            all_list[i] = List.index(j)
            break

print(" ".join(map(str, all_list)))
