#1934
def gcd(x, y):
  if y == 0:
    return x
  else:
    return gcd(y, x%y)
  
def lcm(x, y): 
  result = (x*y) // gcd(x,y)
  return result

num = int(input())

for i in range(num):
  x, y = map(int, input().split(" "))
  print(lcm(x, y))

#13241
a, b = map(int, input().split())
aa, bb = a, b
 
while b > 0:
    a, b = b, a % b
 
print(aa*bb//a)

#1735
def gcd(x,y):
    mod = x % y
    while mod >0:
        x = y
        y = mod
        mod = x % y
    return y    

A, B = map(int, input().split())
C, D = map(int, input().split())
N = gcd(A*D + C*B, B*D) 
print((A*D + C*B)//N, B*D//N)

#2485
import sys
from math import gcd

n = int(sys.stdin.readline())

num = list()
for _ in range(n):
    num.append(int(sys.stdin.readline()))
    
li = list()
for i in range(1, n):
    li.append(num[i] - num[i - 1])
    
g = li[0]
for i in range(1, len(li)):
    g = gcd(g, li[i])

result = 0
for i in li:
    result += i // g - 1

print(result)

#
