n,k = map(int,raw_input().strip().split())
a = []
ans = 0
while n:
    l,t = map(int,raw_input().strip().split())
    if not t:
        ans += l
    else:
        a.append(l)
    n-=1

ln = len(a)
a.sort(reverse=True)
#print a
ans += sum(a[0:k])
ans -= sum(a[k:])
print ans
