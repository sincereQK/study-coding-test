x= int(input())
y= int(input())

if x > 0 and y > 0 :
    print('1')
elif x < 0 and y > 0 :
    print('2')
elif x < 0 and y < 0 :
    print('3')
else:
    print('4')

# 10871
n, x = map(int, input().split())
num = list(map(int, input().split()))

for i in range(n):
    if num[i] < x:
        print(num[i], end = " ")

# 1316
N = int(input())
cnt = N

for i in range(N):
    word = input()
    for j in range(0, len(word)-1):
        if word[j] == word[j+1]:
            pass
        elif word[j] in word[j+1:]:
            cnt -= 1
            break

print(cnt)

#10811
n,m = map(int, input().split())
basket = [i for i in range(1,n+1)]
temp = 0
for x in range(m):
  i,j = map(int, input().split())
  temp = basket[i-1:j]
  temp.reverse()
  basket[i-1:j] = temp

for x in range(n):
  print(basket[x],end=" ")

