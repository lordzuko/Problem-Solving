n = int(raw_input().strip())
a = map(int,raw_input().strip().split())

mn = 1000000
x = False
for i in range(n):
    for j in range(i+1,n):
        if a[i] == a[j]:
            x = True
            mn = min(abs(i-j),mn)

if x:
    print -1
else:
    print  mn
