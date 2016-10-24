n = int(raw_input().strip())
z = {}
for i in range(n):
    x = int(raw_input().strip())
    if z.has_key(x):
        z[x].append(i)
    else:
        z[x] = []
        z[x].append(i)

k = z.keys()
s = 0
for i in k:
    l = len(z[i])
    #print l
    s+= abs(z[i][0] - z[i][l-1])

print s