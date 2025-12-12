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

#4134
def isprime(num):     #소수인지 판별하는 함수. 소수면 True를 반환. 아니면 False를 반환
    start=2

    while 2<=start<=num**0.5:  #루트N까지만 나누어보는 것이 시간단축의 핵심
        if num%start==0:      #나눠지면 합성수이므로 False를 반환
          return False
        start+=1
    return True

num=int(input())
for _ in range(num):
    test= int(input())
    while True: 
        if test==0 or test==1:  #0과 1이 입력되면 2를 출력
            print(2)
            break
        if isprime(test):       #소수라면 출력
            print(test)
            break
        else:
            test+=1            #소수가 아니면 1을 더해서 다시 수행


#1929
N, M = map(int, input().split())

for i in range(N, M+1):
    if i == 1: # 1은 통과
        continue
        
    for j in range(2, int(i**0.5) + 1): # 2 ~ 제곱근 사이 값 확인
        if i % j == 0: # 나누어 떨어진다면 그대로 종료 (else문 실행 X)
            break
    else: # for문이 잘 실행이 되었다면 print(i) 출력
        print(i)

#4948
num = 123456*2+1
num_list = [1]*num
for i in range(1, num):
    if i == 1:
        continue
    for j in range(2, int(i**0.5)+1):
        if i % j == 0:
            num_list[i] = 0
            break

while True:
    n = int(input())
    
    if n == 0:
        break
    
    prime = 0
    for i in range(n+1, 2*n+1):
            prime += num_list[i]
    print(prime)

#17103
import sys

li = list(True for _ in range(1000001))
li[0] = False
li[1] = False
for i in range(2, 1000001):
    if li[i]:
        for j in range(i * 2, 1000001, i):
            li[j] = False
        
T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    
    count = 0
    for i in range(2, N // 2 + 1):
        if (li[i] and li[N - i]):
            count += 1
            
    print(count)

#


