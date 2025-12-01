#10815
import sys
input = sys.stdin.readline
 
N = int(input())
my_list = list(map(int, input().split()))
M = int(input())
check_list = list(map(int, input().split()))
 
dic = {my_list[i] : 1 for i in range(N)}
 
for card in check_list:
    if card in dic:
        print(1, end=" ")
    else:
        print(0, end=" ")

#14425
import sys
input = sys.stdin.readline
N, M = map(int, input().split())
S = set()
for i in range(N):
    S.add(input())
ans = 0
for _ in range(M):
    t = input()
    if t in S:
        ans+=1
print(ans)

#7785
import sys

n = int(sys.stdin.readline())
temp = dict()

for _ in range(n):
    a, b = map(str, sys.stdin.readline().split())
    if b == "enter":
        temp[a] = b
    else:
        del temp[a]

temp = sorted(temp.keys(), reverse=True)

for i in temp:
    print(i)

#1620
import sys

N, M = map(int, sys.stdin.readline().split())

d1 = {}
d2 = {}
for i in range(N):
    name = sys.stdin.readline().rstrip()
    d1[i + 1] = name    
    d2[name] = i + 1

for _ in range(M):
    data = sys.stdin.readline().rstrip()
    if (data.isdecimal()):
        print(d1[int(data)])
    else:
     print(d2.get(data))

#10816
import sys
input = sys.stdin.readline

N = int(input())
cards = [*map(int, input().split())]
M = int(input())
candidate = [*map(int, input().split())]

count = {}
for card in cards:
    if card in count:
        count[card] += 1
    else:
        count[card] = 1

for target in candidate:
    result = count.get(target)
    if result == None:
        print(0, end=" ")
    else:
        print(result, end=" ")

#1764
import sys

N, M = map(int, sys.stdin.readline().strip().split())

set1 = set()
set2 = set()

for _ in range(N):
    set1.add(sys.stdin.readline().strip())

for _ in range(M):
    set2.add(sys.stdin.readline().strip())

result = sorted(list(set1 & set2))

print(len(result))

for x in result:
    print(x)

#1269
import sys
input = sys.stdin.readline

n_a, n_b = map(int, input().split())
S_a = set(map(int, input().split()))
S_b = set(map(int, input().split()))

print(len(S_a - S_b) + len(S_b - S_a))

#



