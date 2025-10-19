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
