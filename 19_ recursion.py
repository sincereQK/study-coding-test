#재귀
#27433
def factorial(n):
    if n <= 1:
        ans = 1
    else:
        ans = factorial(n-1) * n
        
    return ans

print(factorial(int(input())))

#10870
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

n = int(input())
print(fibonacci(n))

#25501
def recursion(s, l, r, cnt):
    if l >= r: return [1, cnt]
    elif s[l] != s[r]: return [0, cnt]
    else: return recursion(s, l+1, r-1, cnt+1)

def isPalindrome(s,cnt):
    return recursion(s, 0, len(s)-1,cnt)

for _ in range(int(input())):
    s=input()
    print(*isPalindrome(s,1))

#24060
def merge_sort(arr):
    if len(arr) <= 1 :
        return arr
    mid = (len(arr)+1)//2
    low_arr = merge_sort(arr[:mid])
    high_arr = merge_sort(arr[mid:])
    
    sorted_arr= []
    l=h=0
    while l < len(low_arr) and h < len(high_arr):
        if low_arr[l] <= high_arr[h] :
            sorted_arr.append(low_arr[l])
            ans.append(low_arr[l])
            l += 1
        else :
            sorted_arr.append(high_arr[h])
            ans.append(high_arr[h])
            h += 1
            
    while l < len(low_arr) :
        sorted_arr.append(low_arr[l])
        ans.append(low_arr[l])
        l += 1
    
    while h < len(high_arr):
        sorted_arr.append(high_arr[h])
        ans.append(high_arr[h])
        h +=1
        
    return sorted_arr

ans = []
N,K = map(int,input().split())
merge_sort(list(map(int,input().split())))
print(ans[K-1] if K <= len(ans) else -1) 

#4779
from sys import stdin

input = stdin.readline

def cantor(n):
    if n == 1:
        return "-"

    cantor_unit = cantor(n // 3)
    cantor_res = cantor_unit + " " * (n // 3) + cantor_unit

    return cantor_res

while True:
    try:
        N = int(input())
        print(cantor(3**N))
    except:
        break

#

