import sys

def backTracking(cnt):
    global flag

    if cnt == 3:
        if bfs():
            flag = True
            return
    else:
        for x in range(n):
            for y in range(n):
                if graph[x][y] == "X":
                    graph[x][y] = "O"
                    backTracking(cnt + 1)
                    graph[x][y] = "X"

def bfs():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    for t in teacher:
        for k in range(4):
            nx, ny = t

            while 0 <= nx < n and 0 <= ny < n:
                if graph[nx][ny] == "O":
                    break

                if graph[nx][ny] == "S":
                    return False

                nx += dx[k]
                ny += dy[k]

    return True

n = int(sys.stdin.readline())
flag = False
graph = []
teacher = []

for i in range(n):
    graph.append(list(map(str, sys.stdin.readline().split())))
    for j in range(n):
        if graph[i][j] == "T":
            teacher.append([i, j])

backTracking(0)

if flag:
    print("YES")
else:
    print("NO")