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

#

