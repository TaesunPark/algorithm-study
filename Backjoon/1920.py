import bisect

N = int(input())
s_list = list(map(int, input().split(' ')))
s_list.sort()
M = int(input())
d_list = list(map(int, input().split(' ')))

for i in range(M):
	if bisect.bisect_right(s_list, d_list[i]) - bisect.bisect_left(s_list, d_list[i]) != 0:
		print("1")
	else:
		print("0")