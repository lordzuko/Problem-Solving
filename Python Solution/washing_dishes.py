from operator import itemgetter
n,k = map(int,raw_input().split())
p = []
a = 0
for i in range(0,n):
    p.append(map(int,raw_input().split()))
    a-=p[i][1]

p.sort(key=itemgetter(0),reverse=True)

for x in range(0,k):
    a+=p[x][0]+p[x][1]

print a