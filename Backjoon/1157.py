input_array = input().upper()
rm_overlap_array = list(set(input_array))
max_char = []
max_count = []

for i in rm_overlap_array:
    max_count.append(input_array.count(i))

if max_count.count(max(max_count)) > 1:
    print('?')
else:
    max_index = max_count.index(max(max_count))
    print(rm_overlap_array[max_index])