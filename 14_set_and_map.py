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

#
