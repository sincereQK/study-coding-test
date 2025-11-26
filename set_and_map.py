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
      
