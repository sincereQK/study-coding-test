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

#
