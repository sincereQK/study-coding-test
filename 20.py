#15649
n, m = list(map(int, input().split()))

s = []

def dfs():
    if len(s) == m:
        print(' '.join(map(str, s)))
        return

    for i in range(1, n + 1):
        if i not in s:
            s.append(i)
            dfs()
            s.pop()

dfs()

#15650
N, M = map(int, input().split())
S = []
 
def backtraking(start):
    if len(S) == M:
        print(*S)
        return
    
    for i in range(start, N+1):
        if i not in S:
            S.append(i)
            backtraking(i+1)
            S.pop()
 
backtraking(1)

#

