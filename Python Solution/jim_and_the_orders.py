from operator import itemgetter
n = int(raw_input())
l = []
for i in range(n):
    a,b = map(int,raw_input().split())
    l.append((i+1,a+b))

l.sort(key=itemgetter(1))
for i in range(n):
    print l[i][0],