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


#2903
n = int(input())

side = (1 + 2**n)
print(side**2)

#2292
n = int(input())
nums_pileup = 1
cnt = 1
while n > nums_pileup :
    nums_pileup += 6 * cnt

#1193
N = int(input())

line = 0
line_end_num = 0

while line_end_num < N:
    line += 1
    line_end_num += line

K = line_end_num - N

if line % 2 == 0:
    a = line - K
    b = K + 1
else:
    a = K + 1
    b = line - K

print(str(a) + '/' + str(b))
    cnt += 1
print(cnt)

#2581
start_num = int(input())
last_num = int(input())

sosu_list = []
for num in range(start_num, last_num+1):
    error = 0
    if num > 1 :
        for i in range(2, num): 
            if num % i == 0:
                error += 1
                break  
        if error == 0:
            sosu_list.append(num) 
			
if len(sosu_list) > 0 :
    print(sum(sosu_list))
    print(min(sosu_list))
else:
    print(-1)

#2581
M = int(input())
N = int(input())

sosu_list = []
for num in range(M, N+1):
    count = 0 
    if num > 1:
        for i in range(2, num): 
            if num % i == 0: 
                count += 1
                break
        if count == 0: 
            sosu_list.append(num)


if len(sosu_list) > 0:
    print(sum(sosu_list))
    print(min(sosu_list))
else:
    print(-1)

#10926
print(input() + "??!")

#1085
x,y,w,h=map(int,input().split())
print(min(x,y,w-x,h-y))

#15894
print(int(input()) * 4)

#3009
x_nums = []
y_nums = []
for _ in range(3):
    x, y = map(int, input().split())
    x_nums.append(x)
    y_nums.append(y)

for i in range(3):
    if x_nums.count(x_nums[i]) == 1:
        x4 = x_nums[i]
    if y_nums.count(y_nums[i]) == 1:
        y4 = y_nums[i]
print(x4, y4)

#24264
n = int(input())
print(n**2)
print(2)

#24266
n = int(input())
sum = 0
num = n-2
for i in range(1, n-1):
  sum += (num * i)
  num -= 1

print(sum)
print(3)


#2798
import sys
input = sys.stdin.readline

N, M = map(int,input().split())
cards = list(map(int,input().split()))
sum = 0

for i in range(N):
    for j in range(i+1, N-1):
        for k in range(j+1, N):
        	# 첫자리를 더한 수가 M보다 클 경우 다시 뽑음
            if cards[i] + cards[j] + cards[k] > M:
                continue
            # 아니라면 M과 최대한 가깝게 만들기
            else:
                sum = max(sum, (cards[i]+cards[j]+cards[k]))

#2231
n = int(input())
result = 0
for i in range(1, n):
    a = list(map(int, str(i)))
    s = i + sum(a)
    if s == n:
        result = i
        break
print(result)

#19532
a, b, c, d, e, f = map(int, input().split())
for i in range(-999, 1000):
    for j in range(-999, 1000):
        if (a*i) + (b*j) == c and (d*i) + (e*j) == f:
            print(i,j)
print(sum)


