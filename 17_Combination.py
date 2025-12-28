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

#
