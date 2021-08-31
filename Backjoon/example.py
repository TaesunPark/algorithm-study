arr = input()
index1 = [0 for i in range(26)]
for i in range(ord('a'), ord('z')+1):
    for j in arr:
        if chr(i) == j:
            index1[ord(j) - ord('a')] = arr.find(j)

print(index1)