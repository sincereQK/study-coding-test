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

#
