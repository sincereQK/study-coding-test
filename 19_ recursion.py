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

#
