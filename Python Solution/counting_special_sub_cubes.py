q = int(raw_input().strip())
while q:
    n = int(raw_input().strip())
    a = map(int,raw_input().strip().split())

    for i in range(2):
        for j in range(2):
            for k in range(2):
                x = i*(n**2) + j*n + k+1
                print str((i + 1, j + 1, k + 1)) +" -> " + str(a[x-1])

        q -= 1



