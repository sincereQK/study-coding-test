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

#1546
n = int(input())  # 과목 수
test_list = list(map(int, input().split()))
max_score = max(test_list)

new_list = []
for score in test_list :
    new_list.append(score/max_score *100)  # 새로운 점수 생성
test_avg = sum(new_list)/n
print(test_avg)

#10810
n, m=map(int, input().split())
box = [0]*n

for _ in range(m) :
    i,j,k = map(int, input().split())
    for idx in range(i, j+1):
        box[idx-1] = k
for i in range(n):
    print(box[i], end=' ')

# 11718
while True :
    try :
        print(input())
    except EOFError:
        break

#2566
table = [list(map(int, input().split())) for _ in range(9)]
max_num = 0
max_row, max_col = 0, 0
for row in range(9):
    for col in range(9):
        if max_num <= table[row][col]:
            max_row = row + 1
            max_col = col + 1
            max_num = table[row][col]

print(max_num)
print(max_row, max_col)

#9086
n=int(input())
for i in range(n):
    word=input()
    print(word[0]+word[-1])

#3003
chess = [1, 1, 2, 2, 2, 8]

myInput = list(map(int, input().split()))

for i in range(len(chess)):
  print(chess[i] - myInput[i], end = ' ')

#2444
N = int(input())

for i in range(1, n + 1):
    print(" " * (n - i) + "*" * (2 * i - 1))
    
for i in range(n - 1, 0, -1):
    print(" " * (n - i) + "*" * (2 * i - 1))

#2745
N,B = input().split(" ")
N = ''.join(reversed(N))
B = int(B)
number = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
result = 0 

for x in range(len(N)-1,-1,-1):
	sum = number.index(N[x]) * (B**x)
	result += sum
    
print(result)

#2720
t = int(input())
for _ in range(t):
    c = int(input())

    for i in [25, 10, 5, 1]:
        print(c // i, end=" ")
        c %= i
