n,k = map(int,raw_input().split())
a = map(int,raw_input().split())

b = [None]*(n+1)
for i in range(n):
    b[a[i]] = i+1

print b
p = 1
for i in range(n,0,-1):


