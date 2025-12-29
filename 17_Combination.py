#15439
n = int(input())
print(n * (n-1))

#24723
print(2**int(input()))

#10872
n = int(input())

result = 1
if n > 0:
    for i in range(1, n+1):
        result *= i
print(result)

#11050
n,k = map(int,input().split())
a = 1
b = 1
c = 1

for _ in range(1,n+1):
    a *= _
for i in range(1,n-k+1):
    b *= i
for j in range(1,k+1):
    c *= j
print(int(a/(b*c)))

#extra
import math

n, k = map(int, input().split())
print(int(math.factorial(n)/(math.factorial(k)*math.factorial(n-k))))

#1010
import sys
input = sys.stdin.readline

def bridge(n, m):
  dp = [[0 for _ in range(m+1)] for _ in range(n+1)] 
  
  for i in range(1, m+1): dp[1][i] = i # N = 1일 때

  # N이 2 이상일 때 
  for i in range(2, n+1): 
    for j in range(i, m+1):
      for k in range(j, i-1, -1):
        dp[i][j] += dp[i-1][k-1]

  return dp[n][m]

T = int(input())
for _ in range(T):
  N, M = map(int, input().split())
  print(bridge(N,M))

#end
