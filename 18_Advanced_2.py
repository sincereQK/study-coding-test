#심화 2
#1037
N = int(input())
A = list(map(int, input().split()))

max_num = max(A)
min_num = min(A)

print(max_num * min_num)

#25192
import sys
input = sys.stdin.readline
 
N = int(input())
 
names = set()
cnt = 0
 
for i in range(N):
    name = input().strip()
 
    if name == 'ENTER':
        cnt += len(names)
        names = set()
    else:
        names.add(name)
 
cnt += len(names)
print(cnt)

#26069
N = int(input())
dancePeople = {"ChongChong"}
 
for _ in range(N):
    A, B = input().split()
 
    if A in dancePeople:
        dancePeople.add(B)
    if B in dancePeople:
        dancePeople.add(A)
 
print(len(dancePeople))

#2108번
import sys

input = sys.stdin.readline

n = int(input())
data = []

_sum = 0
count = dict()
for _ in range(n):
    x = int(input())
    data.append(x)

    _sum += x

    if x not in count:
        count[x] = 1
    else:
        count[x] += 1

data.sort()

print(round(_sum/n))

print(data[n//2])

freq = max(count.values())
numbers = []
for key, value in count.items():
    if value == freq:
        numbers.append(key)

if len(numbers) == 1:
    print(numbers[0])
else:
    print(sorted(numbers)[1])

print(data[-1] - data[0])

#20920
import sys

N, M = map(int, sys.stdin.readline().split())

d = {}
for _ in range(N):
    word = sys.stdin.readline().rstrip()
    
    if (len(word) < M):
        continue
        
    if (word in d):
        d[word] += 1
    else:
        d[word] = 1

d = sorted(d.items(), key = lambda x : x[0])
d = sorted(d, key = lambda x : len(x[0]), reverse=True)
d = sorted(d, key = lambda x : x[1], reverse=True)

for i in d:
    print(i[0])
