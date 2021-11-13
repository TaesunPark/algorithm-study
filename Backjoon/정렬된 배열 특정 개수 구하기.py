import bisect
N, M = list(map(int, input().split(' ')))

b_list = list(map(int, input().split(' ')))

result_right = bisect.bisect_right(b_list, M)
result_left = bisect.bisect_left(b_list, M)

if result_left == result_right:
	print("-1")
else:
	print(result_right-result_left)

