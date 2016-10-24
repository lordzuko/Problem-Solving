n, m = raw_input().split(" ")
n = int(n)
m = int(m)
matrix = []
for i in range(0, n):
    l = []
    l = raw_input().split(" ")
    matrix.append(l)

for j in range(0, m):
    for i in range(0, n):
        print matrix[i][j],

    print