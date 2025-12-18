#28278
import sys

N = int(sys.stdin.readline()) # 명령의 수 입력 받기
ST = [] # 스택 초기화
for i in range(N): # 5가지의 명령에 대해서 코드 작성
    op = sys.stdin.readline().split() # 1 42 입력하면 ['1', '42']
    if op[0] == '1':
        ST.append(int(op[-1]))
    elif op[0] == '2':
        if ST:
            print(ST.pop(-1))
            continue
        print(-1)
    elif op[0] == '3':
        print(len(ST))
    elif op[0] == '4':
        if ST:
            print(0)
            continue
        print(1)
    elif op[0] == '5':
        if ST:
            print(ST[-1])
            continue
        print(-1)

#10773
k = int(input())
stack = []
for i in range(k):
    money = int(input())
    if money == 0:
        stack.pop()
    else:
        stack.append(money)

print(sum(stack))

#9012
T = int(input())

for i in range(T):
    stack=[]
    target = input()
    for j in target :
        if j == '(' :
            stack.append(j)
        elif j == ')' :
            if len(stack) != 0:
                stack.pop()
            else :
                print("NO")
                break
    else :
        if len(stack) == 0:
            print("YES")
        else :
            print("NO")

#4949
import sys
while True:
    sen = sys.stdin.readline().rstrip()
    flag = 0
    stack = []
    if sen == '.':
        break
    for i in sen:
        if i == "(" or i == "[": #열린 괄호면 스택에 넣어준다.
            stack.append(i)
        elif i == ")": #닫는 소괄호가 등장했을 때
            if not stack or stack[-1] == "[": #열린 괄호가 없거나 열린 대괄호가 나오면
                print("no")
                flag = 1
                break
            else:
                stack.pop()
        elif i == "]": # 닫는 대괄호가 등장했을 때
            if not stack or stack[-1] == "(": #열린 괄호가 없거나 열린 소괄호가 나오면
                print("no")
                flag = 1
                break
            else:
                stack.pop()
    if flag == 0:   #앞서 no가 등장하지 않았을 때
        if not stack :  #스택이 비어있다 = 모든 괄호가 짝을 맞췄다
            print("yes")
        else:
            print("no")

#12789
import sys

N = int(sys.stdin.readline())

wait = list(map(int, sys.stdin.readline().split()))
stack = list()
num = 1
while (wait):
    if (len(stack) > 0) and (stack[-1] == num):
        stack.pop()
        num += 1
    else:
        if (wait[0] == num):
            num += 1
        else:
            stack.append(wait[0])

        del wait[0]

while (stack):
    if (stack[-1] == num):
        stack.pop()
        num += 1
    else:
        break

if (len(stack) == 0):
    print('Nice')
else:
    print('Sad')

#

