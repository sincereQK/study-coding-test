#2751
# import sys

n = int(input())
nums = []

for _ in range(n):
    nums.append(int(sys.stdin.readline()))

nums.sort()

for num in nums:
    print(num)

#10989
#import sys
input = sys.stdin.readline

n = int(input())
arr = [0] * (10000 + 1)

for _ in range(n):
    arr[int(input())] += 1

for i in range(len(arr)):
    if arr[i] != 0: 
        for _ in range(arr[i]):
            print(i)
