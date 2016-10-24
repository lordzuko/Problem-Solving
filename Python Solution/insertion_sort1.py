n = int(raw_input().strip())
a = map(int,raw_input().strip().split())
t = a[n-1]
i=0

for i in range(n):
    for j in range(i+1):
        if a[i] < a [j]:
            a[i],a[j] = a[j],a[i]
    if i!=0:
        print ' '.join([str(x) for x in a])
