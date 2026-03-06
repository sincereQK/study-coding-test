
n = int(input())
tall = []
weight = []
for _ in range(n):
  t, w = map(int, input().split())
  tall.append(t)
  weight.append(w)

# 자신보다 덩치가 큰 사람 수
bigger_cnt = []
for i in range(n):
  bigger = 0 # 나보다 큰 사람 수
  same = 0 # 나랑 덩치가 같은 사람 수
  for j in range(n):
    if tall[i] < tall[j] and weight[i] < weight[j]:
      bigger += 1
    elif (tall[i] <= tall[j] and weight[i] >= weight[j]) or (tall[i] >= tall[j] and weight[i] <= weight[j]) :
      same += 1
  bigger_cnt.append((bigger, same))

ratings = [bigger_cnt[i][0]+1 for i in range(n)]
for r in ratings:
  print(r, end=' '